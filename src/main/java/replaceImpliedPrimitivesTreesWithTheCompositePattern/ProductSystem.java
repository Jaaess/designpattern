package replaceImpliedPrimitivesTreesWithTheCompositePattern;

public class ProductSystem {


    public static void main(String[] args) {

        ProductComponent produce = new ProductGroup("Produce");
        ProductComponent cereal = new ProductGroup("Cereal");

        ProductComponent everyProduct = new ProductGroup("All Product \n");

        everyProduct.add(produce);
        everyProduct.add(cereal);

        produce.add(new Product("Tomato",1.99));
        produce.add(new Product("Orange",.99));
        produce.add(new Product("Potato",.35));

        cereal.add(new Product("Special K",3.99));
        cereal.add(new Product("Cheerios",3.99));
        produce.add(new Product("Raisin Bran",3.35));

        everyProduct.displayProductInfo();

    }

}
