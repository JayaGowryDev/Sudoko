public class Sudoko{
    
    static boolean solve(char[][] board){
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                char last=(char)(n +'0');
                if (board[i][j]=='.') {
                    for(char c='1';c<=last;c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean  isValid(char[][] board , int row, int col, char c){
        int n=board.length;
        int s=(int)Math.sqrt(n);
        for(int i=0;i<n;i++){
            if(board[i][col]==c){
                return false;
            }
            if(board[row][i]==c){
                return false;
            }
            if((board[s * (row / s) + i / s][s * (col / s) + i % s] == c))
            {
                return false;
            }
        }
        return true;
       
       
    }
    public static void main(String[] args) {
        char[][] board = {
            {'1', '2', '.', '3', '.', '4', '.', '5', '6'},
            {'7', '.', '.', '.', '.', '6', '.', '.', '1'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '8', '4', '.', '9', '.', '2', '.'},
            {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
            {'.', '3', '.', '5', '.', '1', '.', '8', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'9', '.', '.', '2', '.', '.', '.', '.', '8'},
            {'8', '4', '.', '6', '.', '7', '.', '1', '9'}
        };
         int n= board.length;
        solve(board);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}