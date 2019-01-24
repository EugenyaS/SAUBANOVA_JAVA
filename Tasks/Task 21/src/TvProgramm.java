import java.util.Random;

public class TvProgramm {
    private String name;
    private String content;

    public TvProgramm(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public TvProgramm() {
        Random random = new Random();
        this.name="Программа "+random.nextInt();
        this.content = "Содержимое программы \""+this.getName()+"\"";
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void show(){
        System.out.println(getName()+" "+ getContent());
    }
}
