public class ParamStudent implements ParamPeople {
    @Override
    public ParamPeople work(String workName) {
//        return null;
        System.out.println("工作内容是:"+workName);
        return this;
    }

    @Override
    public String time() {

        return "2021-12-02";
    }
}
