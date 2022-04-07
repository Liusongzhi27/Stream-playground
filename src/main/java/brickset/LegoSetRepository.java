package brickset;

import repository.Repository;

/**
 * Represents a repository of {@code LegoSet} objects.
 *
 * @author Liu songzhi
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }


// Method 1 : print the names of first ten names;
    public void printWithNames(){
        getAll().stream()
                        .map(LegoSet::getName)
                        .limit(10)
                        .forEach(System.out::println);
    }

   // Method 2 return an average pieces of Lego bricks
    public Double printWithAveragePieces(){
        return getAll().stream().
                mapToInt(LegoSet::getPieces).
                average().
                getAsDouble();
    }


// Method 3.get those Pieces without Dimensions.
        public void printlegoWithnullDiemnsions() {
            getAll().stream()
                    .filter(legoSet -> legoSet.getDimensions() == null)
                    .map(LegoSet::getPieces)
                    .distinct()
                    .forEach(System.out::println);
        }

    // Method 4. Get those Number without Tags and Dimensions()
        public void printLegoSetWith() {
            System.out.println("Products with missing information number is");
            getAll().stream()
                    .filter(legoSet -> legoSet.getTags() == null && legoSet.getDimensions() == null)
                    .map(LegoSet::getNumber)
                    .forEach(System.out::println);
        }
    public  void  printlegoPieces(){
       getAll().stream().
        filter(LegoSet->LegoSet.getPieces() <10)
               .map(LegoSet::getName)
               .forEach(System.out::println);
  }

        public static void main (String[]args){
            var repository = new LegoSetRepository();
           // repository.printLegoSetWith111();
            System.out.println("Method 1 "+"is :");
            repository.printWithNames();
            System.out.println("==============");
            System.out.println("Method 2"+ "is :");
            System.out.println(repository.printWithAveragePieces());
            System.out.println("==============");
            System.out.println("Method 3"+"is :");
            repository.printlegoWithnullDiemnsions();
            System.out.println("==============");
            System.out.println("Method 4"+"is :");
            repository.printLegoSetWith();
            System.out.println("==============");
            System.out.println("Method 5"+"is :");
            repository.printlegoPieces();
            System.out.println("==============");
        }
    }

