
public class PieceWorker extends Employee{
    private double wage;
    private int pieces;

    public PieceWorker(String first, String last, String ssn, double wage, int pieces) {
        super(first, last, ssn);
        setWage( wage ); // validate wage
        setPieces(pieces); // validate pieces
    }




    // set wage
    public void setWage( double Wage )
    {
        if ( Wage >= 0.0 )
            wage = Wage;
        else
            throw new IllegalArgumentException("Wage must be >= 0.0" );
    } // end method setWage

    // return wage
    public double getWage()
    {
        return wage;
    } // end method getWage

    // set pieces
    public void setPieces( int Pieces )
    {
        if (Pieces >= 0.0)
            pieces = Pieces;
        else
            throw new IllegalArgumentException("Hours worked must be >= 0.0" );
    } // end method setPieces

    // return pieces
    public double getPieces()
    {
        return pieces;
    } // end method getPieces



    @Override
    public double earnings() {
        return wage * pieces;
    } // end method earnings


    // return String representation of PieceWorker object
    @Override public String toString() {
        return String.format( "piece worker: %s\n%s: $%,.2f\n%s: %,.2f",
                super.toString(),
                "wage", getWage(),
                "pieces", getPieces() );
    }
}
