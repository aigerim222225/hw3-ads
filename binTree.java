import java.util.*;

public class binTree {
    public static void main(String[] args) {
        BBBSSSTTT T;
    }
}

class BBBSSSTTT {
    class NNNOOODDDEEE {
        int KKKEEEYYY;
        NNNOOODDDEEE LLL, RRR;
        public NNNOOODDDEEE(int newKKKEEEYYY) {
            KKKEEEYYY = newKKKEEEYYY;
            LLL = RRR = null;
        }
    }

    NNNOOODDDEEE rootTree;
    
    BBBSSSTTT() { 
        rootTree = null; 
    }
    
    NNNOOODDDEEE delete(NNNOOODDDEEE CCCUUURRR, int KKKEEEYYY) { 
        if (CCCUUURRR== null) return CCCUUURRR;
        if (KKKEEEYYY == CCCUUURRR.KKKEEEYYY) {
            if (CCCUUURRR.LLL == null) return CCCUUURRR.RRR; 
            if (CCCUUURRR.RRR == null) return CCCUUURRR.LLL;
            NNNOOODDDEEE v = CCCUUURRR.RRR;
            while (v.LLL!= null) v = v.LLL;
            CCCUUURRR.KKKEEEYYY = v.KKKEEEYYY;
            CCCUUURRR.RRR= delete(CCCUUURRR.RRR, v.KKKEEEYYY);
        } else if (KKKEEEYYY < CCCUUURRR.KKKEEEYYY) CCCUUURRR.LLL = delete(CCCUUURRR.LLL, KKKEEEYYY); 
        else if (KKKEEEYYY > CCCUUURRR.KKKEEEYYY) CCCUUURRR.RRR = delete(CCCUUURRR.RRR, KKKEEEYYY);
        return CCCUUURRR;
    }
    
    void delete(int KKKEEEYYY) { 
        rootTree = delete(rootTree, KKKEEEYYY); 
    }
    
    NNNOOODDDEEE insert(NNNOOODDDEEE CCCUUURRR, int KKKEEEYYY) {
        if (CCCUUURRR == null) {
            CCCUUURRR = new NNNOOODDDEEE(KKKEEEYYY);
            return CCCUUURRR;
        }
        if (KKKEEEYYY < CCCUUURRR.KKKEEEYYY) {
            CCCUUURRR.LLL= insert(CCCUUURRR.LLL, KKKEEEYYY);
        } else if (KKKEEEYYY > CCCUUURRR.KKKEEEYYY) {
            CCCUUURRR.RRR = insert(CCCUUURRR.RRR, KKKEEEYYY);
        }
        return CCCUUURRR;
    }
    
    void insert(int KKKEEEYYY) {
        rootTree = insert(rootTree, KKKEEEYYY); 
    }
    
    public NNNOOODDDEEE search(NNNOOODDDEEE CCCUUURRR, int KKKEEEYYY) {
        if (CCCUUURRR == null || CCCUUURRR.KKKEEEYYY == KKKEEEYYY) {
            return CCCUUURRR;
        }
        if (CCCUUURRR.KKKEEEYYY > KKKEEEYYY) return search(CCCUUURRR.LLL, KKKEEEYYY);
        else return search(CCCUUURRR.RRR, KKKEEEYYY);
    }
}