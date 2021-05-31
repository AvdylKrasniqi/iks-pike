#include <iostream>
#include <string>

using namespace std;

char board[3][3];

int sign = 0;

void printBoard() 
{
    for(int i = 0; i < 3; i++) 
    {
        for(int j = 0; j < 3; j++)
        {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
}


bool checkLegalMove(int x_coord, int y_coord)
{
    if(x_coord < 0 || y_coord < 0 || x_coord > 2 || x_coord > 2) return false;
    return board[x_coord][y_coord] == '-';
}

/*
//isMoveLeft - i pa optimizuar
bool isMoveLeft()
{
    for(int i = 0; i < 3; i++) 
{
        for(int j = 0; j < 3; j++) 
{
            if(board[i][j] != ‘-’)
{
                return true;
            }
}
}
return true;
}
*/


// Funksioni isMoveLeft i optimizuar
bool isMoveLeft()
{
    return sign < 9;
}


void move(int x_coord, int y_coord, char sign)
{
 board[x_coord][y_coord] = sign;  
}

bool checkForWinner() 
{
    if(sign < 5)  {
//early return ne rast se nuk kaluar numrin e levizjeve te nevojshem per te fituar lojen.
        return false;  
    }
    for(int i = 0; i < 3; i++){ 

//shiko nese eshte mbyllur ndonje rresht
      if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) 
        return true;


//shiko nese eshte mbyllur ndonje kolone  
    if(board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) 
        return true;
    }

//shiko nese eshte mbyllur matrica e parë
if(board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;

//shiko nese eshte mbyllur matrica e dytë
if(board[2][0] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) 
    return true;

return false;

}

int main()
{
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            board[i][j] = '-';   
        }
    }
    while(isMoveLeft()) {   
        int x_coord, y_coord;
        do {
            cout << "Shkruani koordinaten x: ";
            cin >> x_coord;
            
            cout << "Shkruani koordinaten y: ";
            cin >> y_coord;

        } while( !checkLegalMove(x_coord, y_coord) );
        
        move(x_coord, y_coord, (sign++)%2 ? 'x' : 'o');
        
        printBoard();
        
        if(checkForWinner()) {
                 //shfaq mesazhin e fituesit dhe dil nga while loop.
            cout << "Player " << ((sign - 1) % 2 == 1 ? "x" : "o") << " won!" << endl;
            break; 
        }
    }
    cout << "The End";
    return 0;
}
