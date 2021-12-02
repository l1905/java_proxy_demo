public class SubjectProxy implements ISubject {

    private ISubject target;

    public SubjectProxy(ISubject target) {
        this.target = target;
    }

    @Override
    public void request() {
        System.out.println("before---rqeust----");
        this.target.request();
        System.out.println("after----request----");
    }
}
