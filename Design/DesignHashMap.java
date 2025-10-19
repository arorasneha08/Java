// import java.util.ArrayList;
// import java.util.List;

// // import javax.swing.text.html.HTMLDocument.Iterator;

// public class DesignHashMap {
//     class Pair {
//         int key;
//         int val;

//         Pair(int key, int val) {
//             this.key = key;
//             this.val = val;
//         }
//     }

//     class MyHashMap {
//         List<Pair>[] mpp;
//         int size = 1000;

//         public MyHashMap() {
//             mpp = new List[size];
//             for (int i = 0; i < size; i++) {
//                 mpp[i] = new ArrayList<>();
//             }

//         }

//         private int hash(int key) {
//             return key % size;
//         }

//         public void put(int key, int value) {
//             int idx = hash(key);
//             for (Pair pair : mpp[idx]) {
//                 if (pair.key == key) {
//                     pair.val = value;
//                     return;
//                 }
//             }
//             mpp[idx].add(new Pair(key, value));
//         }

//         public int get(int key) {
//             int idx = hash(key);
//             for (Pair pair : mpp[idx]) {
//                 if (pair.key == key) {
//                     return pair.val;
//                 }
//             }
//             return -1;
//         }

//         public void remove(int key) {
//             int idx = hash(key);
//             Iterator<Pair> it = mpp[idx].iterator();
//             while (it.hasNext()) {
//                 Pair pair = it.next();
//                 if (pair.key == key) {
//                     it.remove();
//                 }
//             }
//         }
//     }
// }
