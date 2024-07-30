import java.util.Scanner;

import java.util.Random;
public class GameHouse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction
        System.out.println("Welcome to the Game House!");
        System.out.println("Explore a collection of classic games designed as part of a Data Structure project.");
        System.out.println("Get ready to embark on nostalgic journeys and challenge your skills.");

        // Game Selection
        while(true){
        System.out.println("\nChoose a game to play:");
        System.out.println("1. Snake and Ladder: Climb the ladders and avoid the snakes to reach the top!");
        System.out.println("2. Guess the Animal: Test your knowledge by guessing the animal based on hints.");
        System.out.println("3. Rock-Paper-Scissors: Engage in the ultimate showdown of choices and outcomes.");
        System.out.println("4. Tic-Tac-Toe: Work Harder by mind to decieve Computer.");
        System.out.println("5. To Exit The Game House!!");
        System.out.print("\nEnter the number of your chosen game: ");
        int chosenGame = scanner.nextInt();

        // Launch the selected game
            switch (chosenGame) {
                case 1:
                Scanner sc = new Scanner(System.in);

                boolean flage = true;
                GameHouse ob1 = new GameHouse();
                do {
        
                    System.out.println("Enter the number of Players: ");
                    int numPlayers = sc.nextInt();
                    sc.nextLine();
        
                    String[] playerNames = new String[numPlayers];
                    for (int i = 0; i < numPlayers; i++) {
                        System.out.println("Enter Player " + (i + 1) + " name: ");
                        playerNames[i] = sc.nextLine();
                    }        
                    SnakeAndLadderGame game = ob1.new SnakeAndLadderGame(playerNames);
                    game.play();
        
                    System.out.println("Do you want to play again !  (yes or no)");
                    String s = sc.next();
        
                    if (s.equals("no")) {
                        flage = false;
                    }
        
                } while (flage);
                    
                    break;
                case 2:                    
                    GameHouse ob2 = new GameHouse();
                    AnimalGussing game2 = ob2.new AnimalGussing();
                    AnimalGussing.GuessTheAnimal g = game2.new GuessTheAnimal();
                    g.PlayAnimal();
                    break;
                case 3:
                    GameHouse ob3 = new GameHouse();
                    RockPaperScissorsGame game3 = ob3.new RockPaperScissorsGame();
                    game3.start();
                    break;
                case 4:
                    GameHouse ob4 = new GameHouse();
                    ob4.new TicTacToe();
                    break;
                case 5:
                    System.out.println("Thanks For Being a Part of Our Game House!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid game number.");
            }
        }
    }
// For Game 3 i.e Rock-Paper-Scissors!!
class Node {
    String data;
    Node next;

    public Node(String data) { //Usage of LinkedList.
        this.data = data;
        this.next = null;
    }
}

class CustomLinkedList {
    Node head;

    public CustomLinkedList() {
        this.head = null;
    }
    /**
     * 
     * @param data
     */
    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}

class RockPaperScissorsGame {

    private CustomLinkedList choices;
    private int playerScore;
    private int computerScore;

    public void start() {
        initialize();
        System.out.println("Welcome to Rock Paper Scissors Game!");

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

            while (playAgain) {
                
                System.out.println("--------------------------------------------------");
                System.out.println("         Welcome to \"Rock-Paper-Scissors\" Game!");
                System.out.println("--------------------------------------------------\n");
                System.out.println("Get ready for a classic game of choices and outcomes.");
                System.out.println("Let's dive into the world of Rock, Paper, and Scissors!");
    
                // How to Play
                System.out.println("\nHow to Play:");
                System.out.println("1. You will choose either rock, paper, or scissors.");
                System.out.println("2. The computer will also make its choice.");
                System.out.println("3. Rock crushes scissors, scissors cut paper,");
                System.out.println("   and paper covers rock.");
                System.out.println("4. The winner is decided based on the choices.");
                System.out.println("\nAre you ready to play? Let's begin!");
                System.out.println("--------------------------------------------------");
                System.out.print("Enter your choice (rock/paper/scissors): ");
                String playerChoice = scanner.next().toLowerCase();
                String computerChoice = getComputerChoice();
    
                System.out.println("Computer chose: " + computerChoice);
                String result = determineWinner(playerChoice, computerChoice);
                System.out.println(result);
    
                System.out.println("Player score: " + playerScore);
                System.out.println("Computer score: " + computerScore);
    
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();
                playAgain = playAgainInput.equalsIgnoreCase("yes");
                if(playAgainInput.equalsIgnoreCase("no")){
                    System.out.println("Thanks for playing Stone Paper Scissors!!");
                    playAgain = false;
                }
            }
        

        System.out.println("Final scores:");
        System.out.println("Player score: " + playerScore);
        System.out.println("Computer score: " + computerScore);

    }

    private void initialize() {
        choices = new CustomLinkedList(); // to Add rock,paper,scissor in each node of the LL.
        choices.add("rock");
        choices.add("paper");
        choices.add("scissors");
        playerScore = 0;
        computerScore = 0;
    }

    private String getComputerChoice() {
        Random random = new Random();
        int choiceIndex = random.nextInt(3);
        Node current = choices.head; // to initialise head in temperory current variable.
        for (int i = 0; i < choiceIndex; i++) {
            current = current.next;
        }
        return current.data; // gives computer data randomly from rock/paper/scissor.
    }

    private String determineWinner(String playerChoice, String computerChoice) { // to determine winner.
        //Check-Cases for the Winner.
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if (playerChoice.equals("rock")) {
            if (computerChoice.equals("scissors")) {
                playerScore++;
                return "You win!";
            } else {
                computerScore++;
                return "Computer wins!";
            }
        } else if (playerChoice.equals("paper")) {
            if (computerChoice.equals("rock")) {
                playerScore++;
                return "You win!";
            } else {
                computerScore++;
                return "Computer wins!";
            }
        } else if (playerChoice.equals("scissors")) {
            if (computerChoice.equals("paper")) {
                playerScore++;
                return "You win!";
            } else {
                computerScore++;
                return "Computer wins!";
            }
        } else {
            return "Invalid choice. Please choose rock, paper, or scissors.";
        }
    }
}
// Game 2 Begins!!
class AnimalGussing {

    class TreeNode {  // Usage of Binary Tree.
        String data;
        TreeNode left;
        TreeNode right;

        public TreeNode(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class GuessTheAnimal {
        void PlayAnimal() {
            Scanner scanner = new Scanner(System.in);
            TreeNode root = createDecisionTree();

            boolean flage = true;

            while (flage != false) {
                System.out.println("--------------------------------------------------");
            System.out.println("         Welcome to \"Guess the Animal\" Game!");
            System.out.println("--------------------------------------------------\n");

            System.out.println("In this interactive text-based game, you'll challenge the computer's guessing abilities");
            System.out.println("as it attempts to guess the animal you're thinking of. The computer will ask a series");
            System.out.println("of questions to narrow down its guess. If it doesn't guess correctly, you'll help it");
            System.out.println("learn and improve its guesses!\n");

            System.out.println("How to Play:");
            System.out.println("1. Think of an animal without revealing it to the computer.");
            System.out.println("2. Answer the computer's yes-or-no questions truthfully.");
            System.out.println("3. If the computer guesses your animal correctly, it wins!");
            System.out.println( "4. If the computer's guess is wrong, you'll provide the correct animal and a new question to help the computer learn.\n");

            System.out.println("Are you ready to outwit the computer? Let the guessing game begin!\n");
                System.out.println("-----------------------------------------------------------------------------------------------");

                playGame(scanner, root);

                System.out.println("Do you want to play again !! (yes or no ??)");
                String s = scanner.nextLine();

                if (s.equalsIgnoreCase("no")) {

                    flage = false;
                    System.out.println("Thanks for playing!");

                }
            }

        }

        public static TreeNode createDecisionTree() { // Asks question based on Tree Nodes.
            GameHouse ob = new GameHouse();
            AnimalGussing a = ob.new AnimalGussing();
            TreeNode root = a.new TreeNode("Is it a mammal?");
            root.left = a.new TreeNode("Does it have stripes?");
            root.left.left = a.new TreeNode("Guess: tiger");
            root.left.right = a.new TreeNode("Does it have a long neck?");
            root.left.right.left = a.new TreeNode("Guess: giraffe");
            root.left.right.right = a.new TreeNode("Does it live in the water?");
            root.left.right.right.left = a.new TreeNode("Guess: dolphin");
            root.left.right.right.right = a.new TreeNode("Does it have a long tail?");
            root.left.right.right.right.left = a.new TreeNode("Guess: kangaroo");
            root.left.right.right.right.right = a.new TreeNode("Guess: dog");

            root.right = a.new TreeNode("Does it have feathers?");
            root.right.left = a.new TreeNode("Is it a bird of prey?");
            root.right.left.left = a.new TreeNode("Guess: eagle");
            root.right.left.right = a.new TreeNode("Does it waddle?");
            root.right.left.right.left = a.new TreeNode("Guess: penguin");
            root.right.left.right.right = a.new TreeNode("Is it colorful and tropical?");
            root.right.left.right.right.left = a.new TreeNode("Guess: parrot");
            root.right.left.right.right.right = a.new TreeNode("Guess: ostrich");

            root.right.right = a.new TreeNode("Is it a reptile?");
            root.right.right.left = a.new TreeNode("Does it have a shell?");
            root.right.right.left.left = a.new TreeNode("Guess: turtle");
            root.right.right.left.right = a.new TreeNode("Is it long and slimy?");
            root.right.right.left.right.left = a.new TreeNode("Guess: snake");
            root.right.right.left.right.right = a.new TreeNode("Does it change colors?");
            root.right.right.left.right.right.left = a.new TreeNode("Guess: chameleon");
            root.right.right.left.right.right.right = a.new TreeNode("Guess: crocodile");

            root.right.right.right = a.new TreeNode("Is it a large land animal?");
            root.right.right.right.left = a.new TreeNode("Is it a wild cat?");
            root.right.right.right.left.left = a.new TreeNode("Guess: lion");
            root.right.right.right.left.right = a.new TreeNode("Guess: horse");
            root.right.right.right.right = a.new TreeNode("Guess: fish");

            return root;
        }

        public static void playGame(Scanner scanner, TreeNode currentNode) {
            if (currentNode.left == null && currentNode.right == null) {
                // Leaf node, make a guess
                System.out.println("Is it " + currentNode.data + "?");
                System.out.print("Enter 'yes' or 'no': ");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("yes")) {
                    System.out.println("Great! I guessed it!");
                    System.out.println();
                } else {
                    System.out.println("Oops! Looks like I need to learn more.");
                    learnNewAnimal(scanner, currentNode);
                }
            } else {
                // Question node, ask the question
                System.out.println(currentNode.data);
                System.out.print("Enter 'yes' or 'no': ");
                String response = scanner.nextLine().toLowerCase();
                System.out.println();
                if (response.equals("yes")) {
                    playGame(scanner, currentNode.left); // if the guess is correct then moves to left sub-tree
                } else {
                    playGame(scanner, currentNode.right); // else heads to the right sub-tree.
                }
            }
        }

        public static void learnNewAnimal(Scanner scanner, TreeNode currentNode) { // if the guess is not there in the tree then it asks for the new guess to add.
            GameHouse ob = new GameHouse();
            AnimalGussing a = ob.new AnimalGussing();//Object of animalGuessing class
            System.out.print("What animal were you thinking of? ");
            String newAnimal = scanner.nextLine();
            System.out
                    .println("Please provide a question to differentiate " + currentNode.data + " from " + newAnimal
                            + ":");
            String newQuestion = scanner.nextLine();

            String oldData = currentNode.data;
            currentNode.data = newQuestion;
            System.out.println("Is the answer to your question 'yes' for " + newAnimal + "?");
            String response = scanner.nextLine().toLowerCase(); // checks the answer.

            if (response.equals("yes")) {
                currentNode.left = a.new TreeNode(newAnimal); // if corrects then shift to left sub tree
                currentNode.right = a.new TreeNode(oldData); // and old answer will be shifted to right sub tree.
            } else {
                currentNode.left = a.new TreeNode(oldData); //if no then old animal will remain in the left sub tree
                currentNode.right = a.new TreeNode(newAnimal);//and new animal will be shifted to right sub tree.
            }
        }
    }
}

// Game 1 Begins!!
class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T item) { // Usage of Queue and LinkedList.
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Iterable<T> frontToRear() {
        return new Iterable<T>() {
            @Override
            public java.util.Iterator<T> iterator() {
                return new java.util.Iterator<T>() {
                    private Node<T> current = front;

                    @Override
                    public boolean hasNext() {
                        return current != null;
                    }

                    @Override
                    public T next() {
                        T data = current.data;
                        current = current.next;
                        return data;
                    }
                };
            }
        };
    }
}

class Player {
    String name;
    int position;

    Player(String name) {
        this.name = name;
        this.position = 0;
    }
}

class SnakeAndLadderGame {
    private static final int BOARD_SIZE = 100;
    private static final int[] SNAKE_POSITIONS = { 97, 93, 63, 54, 33 };
    private static final int[] SNAKE_DESTINATIONS = { 61, 74, 16, 34, 5 };
    private static final int[] LADDER_POSITIONS = { 80, 71, 51, 46, 21, 8, 2 };
    private static final int[] LADDER_DESTINATIONS = { 99, 91, 67, 84, 42, 31, 38 };

    private Queue<Player> playersQueue;
    private boolean gameOver;

    public SnakeAndLadderGame(String[] playerNames) {
        playersQueue = new Queue<>();
        for (String playerName : playerNames) {
            playersQueue.enqueue(new Player(playerName));
        }
        gameOver = false;
    }

    private int rollDice() {
        return new java.util.Random().nextInt(6) + 1; // The argument 6 specifies that the random integer should be between 0 (inclusive) and 6 (exclusive) i.e. from 0 to 5.
        // Hence +1 gives the number from 1 to 6.
    }

    private int getNewPosition(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;

        for (int i = 0; i < SNAKE_POSITIONS.length; i++) {
            if (newPosition == SNAKE_POSITIONS[i]) {
                newPosition = SNAKE_DESTINATIONS[i];
                break;
            }
            // Here this block checks that wheather the newPosition of the player is equals at the snake source position?? if it is so then the new position gets shifited to snake destination position. 
        }

        for (int i = 0; i < LADDER_POSITIONS.length; i++) {
            if (newPosition == LADDER_POSITIONS[i]) {
                newPosition = LADDER_DESTINATIONS[i];
                break;
            }
            // Here this block checks that wheather the newPosition of the player is equals at the Ladder source position?? if it is so then the new position gets shifited to Ladder destination position.
        }

        if (newPosition > BOARD_SIZE) {
            newPosition = BOARD_SIZE - (newPosition - BOARD_SIZE);
            // Here this block ensures that the newPosition shouldnt be greater than board size. and sets the size accordingly.
        }

        return newPosition;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            for (Player player : playersQueue.frontToRear()) { // this will iterate the players from front to rear.
                System.out.println(player.name + "'s turn. Press Enter to roll the dice...");
                sc.nextLine();

                int diceRoll = rollDice(); // this will randomly roll the dice.
                System.out.println(player.name + " rolled a " + diceRoll);

                int newPosition = getNewPosition(player.position, diceRoll); // will get player's new position.
                player.position = newPosition;

                if (newPosition >= BOARD_SIZE) {
                    System.out.println(player.name + " wins!"); // Win Condition
                    gameOver = true;
                }

                System.out.println(player.name + "'s position: " + player.position);
                printGameBoard();
            }
        }
    }

    public void printGameBoard() {
        System.out.println("\nCurrent Game Board:");

        for (int square = 100; square >= 1; square--) { 
            boolean isOccupied = false;
            String occupiedBy = " ";

            for (Player player : playersQueue.frontToRear()) {
                if (player.position == square) {
                    isOccupied = true;
                    occupiedBy = player.name;
                    break;
                }
            } // logic to print the name of the player on dashBoard.

            if (isOccupied) {
                System.out.print(occupiedBy); // Suppose Player-1 is one the position 5 then instead of 5 it will be written 'Player-1'.
            } else {
                System.out.print(square); // In other cases for 1..4 & 6..100 the number itself are printed.
            }

            System.out.print("\t");

            if (square % 10 == 1) {
                System.out.println(); // To print the dashboard at new line after each 10 entries.
            }
        }
        System.out.println();
    }

    public boolean isGameOver() {
        return gameOver;
    }
}

// Game - 4.
class TicTacToe 
{
    char[][] board;
    int count=0;
    Scanner sc = new Scanner(System.in);
    
    TicTacToe()
    {
        
            System.out.println("            Welcome to Tic Tac Toe!");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Prepare for a classic battle of strategy and wits.");
            System.out.println("Enter the world of X and O, where victory awaits!");
            System.out.println("\nHow to Play:");
            System.out.println("1. You and your opponent will take turns.");
            System.out.println("2. The game is played on a 3x3 grid.");
            System.out.println("3. The goal is to create a line of three of your symbols.");
            System.out.println("   It can be a row, column, or diagonal.");
            System.out.println("4. The first player to achieve this wins!");
            System.out.println("\nAre you ready to challenge your opponent? Let's begin!");
            System.out.println("--------------------------------------------------");

        board=new char[3][3];
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("-------------");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("-------------");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
        initializeBoard();
        printBoard();
        makeMove();
    }
    void initializeBoard()   // Initialise the board with space characters
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }
    }
    void printBoard()        // Print Board after every move
    {
        System.out.println("-------------");
        for(int i=0;i<3;i++)
        {
            System.out.print("| ");
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    void placeMark(int pos,char mark,String name)  // Placing mark on board
    {
        if(pos>=1 && pos <=9)
        {
            if(pos==1)
                board[0][0]=mark;
            else if (pos==2)
                board[0][1]=mark;
            else if (pos==3)
                board[0][2]=mark;
            else if (pos==4)
                board[1][0]=mark;
            else if (pos==5)
                board[1][1]=mark;
            else if (pos==6)
                board[1][2]=mark;
            else if (pos==7)
                board[2][0]=mark;
            else if (pos==8)
                board[2][1]=mark;
            else
                board[2][2]=mark;
        }
        else
        {
            System.out.println("Invalid Input");

        }
        printBoard();
        count++;
        if(checkColWin() || checkRowWin() || checkDiagWin())
        {
            System.out.println(name+" Wins");
            
        }
        else
        {
            if(name=="Player"&& count <=8)
            {
                AIMove();
            }
            else if(name=="Player" && count ==9)
            {
                System.out.println("Match Draw");
            }
            else
            {
                makeMove();
            }
        }
    }
    boolean checkColWin()   // Check column win
    {
        for(int i=0;i<3;i++)
        {
            if(board[0][i]!= ' ' && board[0][i]== board[1][i] && board[1][i]==board[2][i])
            {
                return true;
            }
        }
        return false;
    }
    boolean checkRowWin()   // Check row win
    {
        for(int i=0;i<3;i++)
        {
            if(board[i][0]!= ' ' && board[i][0]== board[i][1] && board[i][1]==board[i][2])
            {
                return true;
            }
        }
        return false;
    }
    boolean checkDiagWin()  // Check diagonal win
    {
        if(board[0][0]!= ' ' && board[0][0]== board[1][1] && board[1][1]==board[2][2]
                || board[0][2]!= ' ' && board[0][2]== board[1][1] && board[1][1]==board[2][0])
        {
            return true;
        }

        return false;
    }
    void makeMove()         // Player Move
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter position : ");
        int pos= sc.nextInt();
        if(isValid(pos))
        {
            placeMark(pos,'X',"Player");
        }
        else
        {
            System.out.println("Invalid Move");
            makeMove();
        }
    }
    void AIMove()           // Computer Move
    {
        Random r=new Random();
        int pos=r.nextInt(8)+1; // Again get mark from 0 to 8 both 0 is inclusive and 8 is exclusive. by adding +1 the moves will be from 1 to 9.
        if(isValid(pos))
        {
            placeMark(pos,'O',"Computer");
        }
        else
        {

            AIMove();
        }
    }
    boolean isValid(int pos) // Check if the move is valid
    {
        int row=0,col=0;
        if(pos>=1 && pos<=9)
        {
            if(pos==1)
            {
                row=0;
                col=0;
            }
            else if (pos==2)
            {
                row=0;
                col=1;
            }
            else if (pos==3)
            {
                row=0;
                col=2;
            }
            else if (pos==4)
            {
                row=1;
                col=0;
            }
            else if (pos==5)
            {
                row=1;
                col=1;
            }
            else if (pos==6)
            {
                row=1;
                col=2;
            }
            else if (pos==7)
            {
                row=2;
                col=0;
            }
            else if (pos==8)
            {
                row=2;
                col=1;
            }
            else
            {
                row=2;
                col=2;
            }
        }
        if(board[row][col]==' ')
        {
            return true;
        } // set the Positions to print on the DashBoard.
        return false;
    }

    }
}
/*                                              Test-Cases.
---Run the Code.
Welcome to the Game House!
Explore a collection of classic games designed as part of a Data Structure project.
Get ready to embark on nostalgic journeys and challenge your skills.

Choose a game to play:
1. Snake and Ladder: Climb the ladders and avoid the snakes to reach the top!
2. Guess the Animal: Test your knowledge by guessing the animal based on hints.
3. Rock-Paper-Scissors: Engage in the ultimate showdown of choices and outcomes.
4. Tic-Tac-Toe: Work Harder by mind to decieve Computer.
5. To Exit The Game House!!

Enter the number of your chosen game:



--- Asks for choose a game.
#Test-Case_1 : Enter the number of your chosen game: 1
Enter the number of Players:
    #Test-Case_1 : Enter the number of Players: 1
        #Test-Case_1 : Enter Player 1 name: xyz
        xyz's turn. Press Enter to roll the dice...
        ---After pressing enter..
        xyz rolled a 4
        xyz's position: 4

        Current Game Board:
        100     99      98      97      96      95      94      93      92      91
        90      89      88      87      86      85      84      83      82      81
        80      79      78      77      76      75      74      73      72      71
        70      69      68      67      66      65      64      63      62      61
        60      59      58      57      56      55      54      53      52      51
        50      49      48      47      46      45      44      43      42      41
        40      39      38      37      36      35      34      33      32      31
        30      29      28      27      26      25      24      23      22      21
        20      19      18      17      16      15      14      13      12      11
        10      9       8       7       6       5       xyz     3       2       1

        xyz's turn. Press Enter to roll the dice...
        ---Similar process till xyz reaches 100.
        xyz rolled a 4
        xyz wins!
        xyz's position: 100

        Current Game Board:
        xyz     99      98      97      96      95      94      93      92      91
        90      89      88      87      86      85      84      83      82      81
        80      79      78      77      76      75      74      73      72      71
        70      69      68      67      66      65      64      63      62      61
        60      59      58      57      56      55      54      53      52      51
        50      49      48      47      46      45      44      43      42      41
        40      39      38      37      36      35      34      33      32      31
        30      29      28      27      26      25      24      23      22      21
        20      19      18      17      16      15      14      13      12      11
        10      9       8       7       6       5       4       3       2       1

        Do you want to play again !  (yes or no)
        -- If yes the game starts again.
        -- If No then back to main menu.

#Test-Case_2 : Enter the number of your chosen game: 2
    --------------------------------------------------
            Welcome to "Guess the Animal" Game!
    --------------------------------------------------

    In this interactive text-based game, you'll challenge the computer's guessing abilities
    as it attempts to guess the animal you're thinking of. The computer will ask a series
    of questions to narrow down its guess. If it doesn't guess correctly, you'll help it
    learn and improve its guesses!

    How to Play:
    1. Think of an animal without revealing it to the computer.
    2. Answer the computer's yes-or-no questions truthfully.
    3. If the computer guesses your animal correctly, it wins!
    4. If the computer's guess is wrong, you'll provide the correct animal and a new question to help the computer learn.      

    Are you ready to outwit the computer? Let the guessing game begin!

    -----------------------------------------------------------------------------------------------
    Is it a mammal?
    Enter 'yes' or 'no':
    -- if yes.
    Does it have stripes?
    Enter 'yes' or 'no':
    ....... Similarly it asks question from Binary Tree.
    Then finally -
    Is it Guess: tiger?
    Enter 'yes' or 'no':
        if yes :
            Great! I guessed it!

            Do you want to play again !! (yes or no ??)
        if no :
        Oops! Looks like I need to learn more.
        What animal were you thinking of?
        -----------------------------------
        we have to answer the animal here.
        cat
        Please provide a question to differentiate Guess: tiger from cat:

            is it domestic?
            Is the answer to your question 'yes' for cat?
            if yes:
                then it would be added in root left child.
            if no:
                then it would be added in root right child.
        Do you want to play again !! (yes or no ??)
            if no:
             Back to Main Menu.
            if yes:
             You will be playing it again with 'Cat' Question added.

#Test-Case_3 : Enter the number of your chosen game: 3
    --------------------------------------------------
            Welcome to "Rock-Paper-Scissors" Game!
    --------------------------------------------------

    Get ready for a classic game of choices and outcomes.
    Let's dive into the world of Rock, Paper, and Scissors!

    How to Play:
    1. You will choose either rock, paper, or scissors.
    2. The computer will also make its choice.
    3. Rock crushes scissors, scissors cut paper,
    and paper covers rock.
    4. The winner is decided based on the choices.

    Are you ready to play? Let's begin!
    --------------------------------------------------
    Enter your choice (rock/paper/scissors):
    --- We have to choice one of them.
        -- if i chose rock. then computer will chose randomly one of it.
            Computer chose: scissors
            You win!
            Player score: 1
            Computer score: 0
            -- If Player chose rock and computer chose scissors then Player win.
            -- If Player chose rock and computer chose Paper then Computer win.
            -- If Player chose paper and computer chose rock then Player win.
            -- If Player chose paper and computer chose scissors then Computer win.
            -- If Player chose Scissors and computer chose Paper then Player win.
            -- If Player chose Scissors and computer chose Rock then Computer win.
            -- If Both Player and computer choses the same then its a Tie.
            Do you want to play again? (yes/no):
                if yes: then game will be played again with points they left.
                if no : then return to Main Menu.

#Test-Case_4 : Enter the number of your chosen game: 4
                Welcome to Tic Tac Toe!
    --------------------------------------------------

    Prepare for a classic battle of strategy and wits.
    Enter the world of X and O, where victory awaits!

    How to Play:
    1. You and your opponent will take turns.
    2. The game is played on a 3x3 grid.
    3. The goal is to create a line of three of your symbols.
    It can be a row, column, or diagonal.
    4. The first player to achieve this wins!

    Are you ready to challenge your opponent? Let's begin!
    --------------------------------------------------
    -------------
    | 1 | 2 | 3 |
    -------------
    | 4 | 5 | 6 |
    -------------
    | 7 | 8 | 9 |
    -------------
    -------------
    |   |   |   |
    -------------
    |   |   |   |
    -------------
    |   |   |   |
    -------------
    Enter position :
        -- Here player have to add positions from 1 to 9.
        Enter position : 5 
        -------------
        |   |   |   |
        -------------
        |   | X |   |
        -------------
        |   |   |   |
        -------------
        -------------
        |   |   |   |
        -------------
        |   | X |   |
        -------------
        | O |   |   |
        -------------
        Enter position :
        -- Here it shows the 'X' first for player move and then 'O' for computer move.
        Enter position : 10
        Invalid Input
        -------------
        |   |   |   |
        -------------
        |   | X |   |
        -------------
        | O |   |   |
        -------------
        -------------
        |   |   |   |
        -------------
        | O | X |   |
        -------------
        | O |   |   |
        -------------
        Enter position :
        -- Here if player will give invalid input then our chance will get deducted and computer will play the next move. and the games move so on..
        Enter position : 4
        Invalid Move
        Enter position : 3
        -------------
        |   |   | X |
        -------------
        | O | X |   |
        -------------
        | O |   |   |
        -------------
        -------------
        | O |   | X |
        -------------
        | O | X |   |
        -------------
        | O |   |   |
        -------------
        Computer Wins
        **Here As the 4th position is already occupied then it will give player one more chance. And at last when **the game is over. it displays the Winner.
        Choose a game to play:
        1. Snake and Ladder: Climb the ladders and avoid the snakes to reach the top!
        2. Guess the Animal: Test your knowledge by guessing the animal based on hints.
        3. Rock-Paper-Scissors: Engage in the ultimate showdown of choices and outcomes.
        4. Tic-Tac-Toe: Work Harder by mind to decieve Computer.
        5. To Exit The Game House!!

        Enter the number of your chosen game:

#Test-Case_5 : Enter the number of your chosen game: 5
    Thanks For Being a Part of Our Game House!!
#Test-Case_6 : Enter the number of your chosen game: 6
    Invalid choice. Please select a valid game number.

    Choose a game to play:
    1. Snake and Ladder: Climb the ladders and avoid the snakes to reach the top!
    2. Guess the Animal: Test your knowledge by guessing the animal based on hints.
    3. Rock-Paper-Scissors: Engage in the ultimate showdown of choices and outcomes.
    4. Tic-Tac-Toe: Work Harder by mind to decieve Computer.
    5. To Exit The Game House!!

    Enter the number of your chosen game:5
    Thanks For Being a Part of Our Game House!!
 */