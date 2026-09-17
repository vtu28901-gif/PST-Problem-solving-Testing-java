import java.util.*;

class ThroneInheritance {
    private String kingName;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, key -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(kingName, result);
        return result;
    }

    private void dfs(String name, List<String> result) {
        if (!dead.contains(name)) {
            result.add(name);
        }

        for (String child : children.getOrDefault(name, Collections.emptyList())) {
            dfs(child, result);
        }
    }
}

/*
Output:
["king","andy","matthew","bob","alex","asha","catherine"]
*/
