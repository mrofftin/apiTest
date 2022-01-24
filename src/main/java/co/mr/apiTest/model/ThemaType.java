package co.mr.apiTest.model;

public enum ThemaType {
    HISTORY("종교/역사/전통"),
    STUDY("체험/학습/산업"),
    PLAY("쇼핑/놀이"),
    HEALING("자연/힐링");

    private final String value;

    ThemaType(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
