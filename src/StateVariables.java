public class StateVariables {
    private boolean whiteKingsFirstMove;
    private boolean blackKingsFirstMove;
    private boolean leftWhiteRoocksFirstMove;
    private boolean rightWhiteRoocksFirstMove;
    private boolean leftBlackRoocksFirstMove;
    private boolean rightBlackRoocksFirstMove;
    private boolean didWhiteCastling;
    private boolean didBlackCastling;

    public StateVariables() {
        whiteKingsFirstMove = true;
        blackKingsFirstMove = true;
        leftBlackRoocksFirstMove = true;
        leftWhiteRoocksFirstMove = true;
        rightBlackRoocksFirstMove = true;
        rightWhiteRoocksFirstMove = true;
        didWhiteCastling = false;
        didBlackCastling = false;
    }

    public StateVariables(StateVariables st) {
        whiteKingsFirstMove = st.isWhiteKingsFirstMove();
        blackKingsFirstMove = st.isBlackKingsFirstMove();
        leftBlackRoocksFirstMove = st.isLeftBlackRoocksFirstMove();
        rightWhiteRoocksFirstMove = st.isRightWhiteRoocksFirstMove();
        leftWhiteRoocksFirstMove = st.isLeftWhiteRoocksFirstMove();
        rightBlackRoocksFirstMove = st.isRightBlackRoocksFirstMove();
    }

    public boolean didCastling() {
        return didWhiteCastling || didBlackCastling;
    }

    public boolean didCastling(boolean blackCastrling) {
        return blackCastrling ? didBlackCastling : didWhiteCastling;
    }

    public void setCastling(boolean b, boolean blackCastling) {
        if (blackCastling) {
            didBlackCastling = b;
        } else {
            didWhiteCastling = b;
        }
    }

    public boolean isWhiteKingsFirstMove() {
        return whiteKingsFirstMove;
    }

    public boolean isBlackKingsFirstMove() {
        return blackKingsFirstMove;
    }

    public boolean isLeftWhiteRoocksFirstMove() {
        return leftWhiteRoocksFirstMove;
    }

    public boolean isRightWhiteRoocksFirstMove() {
        return rightWhiteRoocksFirstMove;
    }

    public boolean isLeftBlackRoocksFirstMove() {
        return leftBlackRoocksFirstMove;
    }

    public boolean isRightBlackRoocksFirstMove() {
        return rightBlackRoocksFirstMove;
    }

    public boolean isKingsFirstMove(boolean isBlack) {
        return isBlack ? blackKingsFirstMove : whiteKingsFirstMove;
    }

    public void setKingsFirstMove(boolean kingsFirstMove, boolean isBlack) {
        if (isBlack) {
            blackKingsFirstMove = kingsFirstMove;
        } else {
            whiteKingsFirstMove = kingsFirstMove;
        }
    }

    public boolean isRoocksFirstMove(boolean isBlack, boolean isLeft) {
        if (isBlack) {
            return isLeft ? leftBlackRoocksFirstMove : rightBlackRoocksFirstMove;
        }
        if (!isBlack) {
            return  isLeft ? leftWhiteRoocksFirstMove : rightWhiteRoocksFirstMove;
        }
        return false;
    }

    public void setRoocksFirstMove(boolean roocksFirstMove, boolean isBlack, boolean isLeft) {
        if (isBlack) {
            if (isLeft) {
                leftBlackRoocksFirstMove = roocksFirstMove;
            } else {
                rightBlackRoocksFirstMove = roocksFirstMove;
            }
        } else {
            if (isLeft) {
                leftWhiteRoocksFirstMove = roocksFirstMove;
            } else {
                rightWhiteRoocksFirstMove = roocksFirstMove;
            }
        }
    }
}
