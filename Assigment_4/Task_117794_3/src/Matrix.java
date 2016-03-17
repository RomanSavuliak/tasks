
class Matrix {
    private int [][] data;

    public Matrix(int x) {
        int [][]data = new int[x][x];
        this.data = data;
    }

    public int getIJ(int i, int j) {
        return data[i][j];
    }

    public void setIJ(int value, int i, int j) {
        this.data[i][j] = value;
    }
}
