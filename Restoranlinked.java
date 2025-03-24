import java.util.Scanner; 

// Node untuk menyimpan data pelanggan
class Node {
    String data; // Nama pelanggan
    Node next;   // Pointer ke node berikutnya

    // Membuat node baru
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// Kelas Queue untuk mengelola antrian
class Queue {
    private Node head; // Node depan (pelanggan yang akan dilayani)
    private Node tail; // Node belakang (pelanggan yang baru datang)

    // Inisialisasi antrian kosong
    public Queue() {
        this.head = this.tail = null;
    }

    // Operasi push: Menambahkan pelanggan ke antrian
    public void push(String data) {
        Node newNode = new Node(data); // Buat node baru
        if (tail == null) { // Jika antrian kosong
            head = tail = newNode; // Node baru menjadi head dan tail
        } else {
            tail.next = newNode; // Tambahkan node baru di belakang
            tail = newNode;      // Perbarui tail ke node baru
        }
        System.out.println("Pelanggan " + data + " telah ditambahkan ke antrian.");
        displayQueue(); // Tampilkan antrian setelah operasi push
    }

    // Operasi pop: Melayani pelanggan (menghapus dari antrian)
    public String pop() {
        if (head == null) { // Jika antrian kosong
            System.out.println("Antrian kosong. Tidak ada pelanggan untuk dilayani.");
            return null;
        }
        String data = head.data; // Ambil data pelanggan di depan
        head = head.next;       // Geser head ke node berikutnya
        if (head == null) {      // Jika antrian kosong setelah pop
            tail = null;
        }
        System.out.println("Pelanggan " + data + " telah dilayani.");
        displayQueue(); // Tampilkan antrian setelah operasi pop
        return data;
    }

    // Menampilkan sisa antrian saat ini
    public void displayQueue() {
        Node current = head;
        if (current == null) { // Jika antrian kosong
            System.out.println("Sisa antrian saat ini: Kosong");
            return;
        }
        System.out.print("Sisa antrian saat ini: ");
        while (current != null) {
            System.out.print(current.data + " "); // Tampilkan data pelanggan
            current = current.next; // Pindah ke node berikutnya
        }
        System.out.println();
    }
}

// Kelas utama untuk menjalankan program
public class Restoranlinked {
    public static void main(String[] args) {
        Queue queue = new Queue(); // Buat objek antrian
        Scanner scanner = new Scanner(System.in); // Buat objek Scanner untuk input
        int pilihan;

        do {
            // Menu pilihan
            System.out.println("\nMenu:");
            System.out.println("1. Tambahkan Pelanggan (Push)");
            System.out.println("2. Layani Pelanggan (Pop)");
            System.out.println("3. Keluar");
            System.out.print("Pilih operasi (1/2/3): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline setelah nextInt()

            switch (pilihan) {
                case 1:
                    // Memasukkan nama pelanggan
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.nextLine();
                    queue.push(namaPelanggan); // Tambahkan pelanggan ke antrian
                    break;
                case 2:
                    queue.pop(); // Layani pelanggan
                    break;
                case 3:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);

        scanner.close(); // Tutup Scanner
    }
}
