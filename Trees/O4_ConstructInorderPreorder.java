// import java.util.HashMap;
// import java.util.Map;

// public class O4_ConstructInorderPreorder {
//     // public class TreeNode {
//     //     int val;
//     //     TreeNode left;
//     //     TreeNode right;
//     //     TreeNode() {}
//     //     TreeNode(int val) {
//     //         this.val = val;
//     //     }
//     //     TreeNode(int val, TreeNode left, TreeNode right) {
//     //         this.val = val;
//     //         this.left = left;
//     //         this.right = right;
//     //     }
//     // }
//     // private TreeNode func(int prestart , int preend , int instart , int inend , int inorder[] 
//     // , int preorder[] , HashMap<Integer , Integer> mpp){

//     //     if(prestart > preend || instart > inend) return null; 
//     //     TreeNode root = new TreeNode(preorder[prestart]);  
//     //     int inroot = mpp.get(preorder[prestart]); 
//     //     int numsLeft = inroot - instart ; 

//     //     root.left = func(prestart+1, prestart + numsLeft, instart , inroot , inorder ,preorder , mpp);
//     //     root.right = func(prestart + numsLeft + 1 , preend , inroot + 1 , inend , inorder , preorder , mpp);

//     //     return root ; 
//     // }
//     // public TreeNode buildTree(int[] preorder, int[] inorder) {
//     //     HashMap<Integer , Integer> mpp = new HashMap<>(); 
//     //     for(int i = 0 ; i < inorder.length ; i++){
//     //         mpp.put(inorder[i] , i) ;
//     //     }
//     //     return func(0, preorder.length-1 , 0 , inorder.length-1 , inorder ,preorder , mpp); 
//     // }

//     static int idx = 0 ; 
//     private static Node createTree(int preorder[] , int start , int end , Map<Integer , Integer> mpp){
//         if(start > end) return null; 
//         int val = preorder[idx]; 
//         idx ++; 
//         Node root = new Node(val); 
//         if(start == end) return root; 
        
//         int rootIdx = mpp.get(val); 
//         root.left = createTree(preorder , start , rootIdx - 1 , mpp); 
//         root.right = createTree(preorder , rootIdx + 1 , end , mpp); 
        
//         return root; 
//     }
//     public static Node buildTree(int inorder[], int preorder[]) {
//         int n = inorder.length ; 
//         HashMap<Integer , Integer> mpp = new HashMap<>(); 
//         for(int i = 0 ; i < n ; i++){
//             mpp.put(inorder[i] , i); 
//         }
//         idx = 0 ; 
//         return createTree(preorder , 0 , n-1 , mpp); 
//     }
// }
