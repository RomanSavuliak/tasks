
public class PayrollSystemTest {
    public static void main(String[] args) {
        PieceWorker pieceWorker1 = new PieceWorker("John", "Smith", "1111-111-1111", 20, 11);
        Employee[] employees = new Employee[1];
        employees[0] = pieceWorker1;
        for (Employee currentEmploee : employees){
            System.out.println(currentEmploee);
            System.out.printf("earned $%,.2f\n\n", currentEmploee.earnings());
        }
    }
}
