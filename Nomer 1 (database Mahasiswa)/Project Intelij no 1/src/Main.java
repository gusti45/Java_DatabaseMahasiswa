import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Konfigurasi database
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres"; // Ganti sesuai dengan URL database Anda
        String username = "postgres"; // Ganti sesuai dengan nama pengguna database Anda
        String password = "admin"; // Ganti sesuai dengan kata sandi database Anda

        try {
            // Membuat koneksi ke database
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Membuat statement SQL untuk memasukkan data ke dalam tabel
            String sql = "INSERT INTO mahasiswa (id, nama, jurusan, semester, tahun, gender) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Meminta pengguna untuk memasukkan data
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Jurusan: ");
            String jurusan = scanner.nextLine();
            System.out.print("Masukkan Semester: ");
            int semester = scanner.nextInt();
            System.out.print("Masukkan Tahun: ");
            int tahun = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline
            System.out.print("Masukkan Gender: ");
            String gender = scanner.nextLine();

            // Mengatur nilai parameter PreparedStatement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, jurusan);
            preparedStatement.setInt(4, semester);
            preparedStatement.setInt(5, tahun);
            preparedStatement.setString(6, gender);

            // Menjalankan pernyataan SQL untuk memasukkan data
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke dalam database.");
            } else {
                System.out.println("Gagal memasukkan data ke dalam database.");
            }

            // Menutup sumber daya
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
