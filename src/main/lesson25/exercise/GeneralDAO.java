package main.lesson25.exercise;

public class GeneralDAO {

    private void print(Order order) {
        System.out.println("order id:" + order.toString());
    }

    public <T extends IdEntity> void validate(T t) throws Exception{
        if (t.getId() <= 0)
            throw new Exception("id can't be negative");
    }

    public <K> void validate(K k) {
        if(k.equals(100)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
