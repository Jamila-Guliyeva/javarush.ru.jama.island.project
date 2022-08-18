package javarush.ru.island.jama.location;


public class IslandMap {
    //Coordinates coordinates;
    //public static Cell cell;
    private final Cell[][] areas;

    public IslandMap(int rows, int cols) {
        areas = new Cell[rows][cols];
    }

    public Cell[][] getCells() {
        return areas;
    }
}




//    public void initialize() {
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                map[i][j] = new Cell(i, j);
//            }
//
//        }
//    }

//
//
//
//    public void print(){
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//    }
//
//    public void printInfo() {
//        Map<String, Integer> set = new HashMap<>();
//        for (Cell[] row : map) {
//            for (Cell cell : row) {
//                System.out.print("|\t");
//                Map<OrganismsList, List<Inhabitant>> organismsMap = cell.organismsMap;
//                organismsMap.values()
//                        .stream()
//                        .filter(s -> s.size() > 0)
//                        .forEach(s -> set.put(s.stream().findFirst().get().toString(), s.size()));
//                System.out.print(set);
//                System.out.print("|\t");
//            }
//            System.out.println();
//        }
//    }
//
//    public void countOrganisms() {
//
//        Map<OrganismsList, Integer> organismQuantities = new HashMap<>();
//
//        Map<OrganismsList, Parameters> preferencesMap = GameSettings.getInstance().getParameters();
//        for (OrganismsList organismsList: preferencesMap.keySet()) {
//            organismQuantities.put(organismsList, 0);
//        }
//
//        for (Cell[] row : map) {
//            for (Cell cell : row) {
//                Map<OrganismsList, List<Inhabitant>> organisms = cell.organismsMap;
//                for (Map.Entry<OrganismsList, List<Inhabitant>> organism : organisms.entrySet()) {
//                    organismQuantities.put(organism.getKey(), organism.getValue().size());
//                }
//            }
//        }
//        System.out.println("Total Statistics fot Island is: " + organismQuantities);
//    }
//}
