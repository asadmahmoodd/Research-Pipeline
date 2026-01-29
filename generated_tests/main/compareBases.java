public class compareBases {

    public static boolean compareBases(byte refbase, byte readbase) {
    if (readbase == 61) {
        // By definition, 61 is "equals"
        return true;
    }
    // Force both bases to upper case
    if (refbase > 90) {
        refbase = (byte) (refbase - 32);
    }
    if (readbase > 90) {
        readbase = (byte) (readbase - 32);
    }
    if (refbase == readbase) {
        return true;
    }
    switch(refbase) {
        case 'N':
            // Everything matches 'N'
            return true;
        case 'U':
            return readbase == 'T';
        case 'M':
            return readbase == 'A' || readbase == 'C';
        case 'R':
            return readbase == 'A' || readbase == 'G';
        case 'W':
            return readbase == 'A' || readbase == 'T';
        case 'S':
            return readbase == 'C' || readbase == 'G';
        case 'Y':
            return readbase == 'C' || readbase == 'T';
        case 'K':
            return readbase == 'G' || readbase == 'T';
        case 'V':
            return readbase == 'A' || readbase == 'C' || readbase == 'G';
        case 'H':
            return readbase == 'A' || readbase == 'C' || readbase == 'T';
        case 'D':
            return readbase == 'A' || readbase == 'G' || readbase == 'T';
        case 'B':
            return readbase == 'C' || readbase == 'G' || readbase == 'T';
        default:
            return refbase == readbase;
    }
}

}