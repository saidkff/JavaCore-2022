package ENUMS;

public enum ProcessorType implements Describable {
    BIT_64("Bit_64"),
    BIT_32("Bit_32");

    private String name;

    ProcessorType(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return getName() + " description!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
