package replaceImpliedPrimitivesTreesWithTheCompositePattern;

import java.util.ArrayList;
import java.util.List;

public class ProductGroup extends ProductComponent {

    List<ProductComponent> productComponents = new ArrayList<>();
    private String productGroupName;

    public ProductGroup(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public void add(ProductComponent newProductComponent) {
        productComponents.add(newProductComponent);
    }

    public void remove(ProductComponent newProductComponent) {
        productComponents.remove(newProductComponent);
    }

    public ProductComponent getProductComponent(int componentIndex) {
        return productComponents.get(componentIndex);
    }

    @Override
    public String getProductGroupName() {
        return productGroupName;
    }

    @Override
    void displayProductInfo() {
        System.out.println(getProductGroupName());
        productComponents.stream().forEach(e -> e.displayProductInfo());
        System.out.println();
    }
}
