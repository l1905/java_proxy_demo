public class UpdateProxy implements IUpdate {

    private IUpdate updatable;

    public UpdateProxy(IUpdate updatable) {
        this.updatable = updatable;
    }

    @Override
    public void update() {
        System.out.println("before update proxy");
        this.updatable.update();
        System.out.println("after update proxy");
    }
}
