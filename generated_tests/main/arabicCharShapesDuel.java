public class arabicCharShapesDuel {

    public static boolean arabicCharShapesDuel(char c) {
    int charVal = c;
    if ((charVal == 0x0626) || (charVal == 0x0628) || (charVal >= 0x062A && charVal <= 0x062E) || (charVal >= 0x0633 && charVal <= 0x063A) || (charVal >= 0x0641 && charVal <= 0x0647) || (charVal >= 0x0649 && charVal <= 0x064A) || (charVal >= 0x0678 && charVal <= 0x0687) || (charVal >= 0x069A && charVal <= 0x06BF) || (charVal == 0x6C1) || (charVal == 0x6CC) || (charVal == 0x6CE) || (charVal >= 0x06D0 && charVal <= 0x06D1) || (charVal >= 0x06FA && charVal <= 0x06FC)) {
        return true;
    }
    return false;
}

}