public enum ExtraPerAccident {

    ONE_ACCIDENT(50),
    TWO_ACCIDENTS(125),
    THREE_ACCIDENTS(225),
    FOUR_ACCIDENTS(375),
    FIVE_ACCIDENTS(575),
    MORE_ACCIDENTS(-1);

    public int getExtraToPay() {
        return extraToPay;
    }

    ExtraPerAccident(int extraToPay) {
        this.extraToPay = extraToPay;
    }

    int extraToPay;

}
