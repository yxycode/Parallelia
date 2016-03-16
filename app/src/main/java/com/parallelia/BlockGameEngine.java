package com.parallelia;

import android.view.Window;
import android.view.WindowManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.media.SoundPool;
import android.media.AudioManager;
import android.graphics.Typeface;
import java.util.*;

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class ParabolicCells
{

public final static int MAX_CELLS = 100;
public final static float FLIGHT_SPEED_MULTIPLIER = 5.0f;
public final static float FLIGHT_GRAVITY = 0.35f;

static int[] cell_list = new int[MAX_CELLS];
static float[] x_list = new float[MAX_CELLS];
static float[] y_list = new float[MAX_CELLS];
static float[] DownwardAccelerationList = new float[MAX_CELLS];
static int[] FlightAngleList = new int[MAX_CELLS];
static int[] PitCountList = new int[MAX_CELLS];

static ParabolicCells CurrentObj = new ParabolicCells();

//-------------------------------------------------------------------------------------
private ParabolicCells()
{  
  int i;
  for( i = 0; i < MAX_CELLS; i++ )
  {
	cell_list[i] = 0;
    x_list[i] = 0;
    y_list[i] = 0;
    DownwardAccelerationList[i] = 0;
    FlightAngleList[i] = 0;
    PitCountList[i] = 0;
  }
}
//-------------------------------------------------------------------------------------
public void Add( int cell, int x, int y, int pit_count )
{
  int i;
  
  for( i = 0; i < MAX_CELLS; i++ )
  if( cell_list[i] == 0 )	  
  {	
	cell_list[i] = cell;
	x_list[i] = x; y_list[i] = y;
    DownwardAccelerationList[i] = 0;    
    FlightAngleList[i] = GameGlobals.random(190,340);
    PitCountList[i] = pit_count;
    break;
  }
}
//-------------------------------------------------------------------------------------
public void Do()
{
  int i;
  
  for( i = 0; i < MAX_CELLS; i++ )
  if( cell_list[i] > 0 )	  
  {	
    x_list[i] = x_list[i] + FLIGHT_SPEED_MULTIPLIER * (float)Math.cos(Math.PI/180 * FlightAngleList[i]);
    y_list[i] = y_list[i] + FLIGHT_SPEED_MULTIPLIER * (float)Math.sin(Math.PI/180 * FlightAngleList[i]);
    y_list[i] = y_list[i] + DownwardAccelerationList[i];
	DownwardAccelerationList[i] += FLIGHT_GRAVITY;
	
    if( y_list[i] > GameEngine.TARGET_SCREEN_HEIGHT )
      cell_list[i] = 0;	  
  }	
}
//-------------------------------------------------------------------------------------
public void Draw()
{
  int i;
  
  for( i = 0; i < MAX_CELLS; i++ )
  if( cell_list[i] > 0 )	  
     BlockGameEngine.DrawCell( cell_list[i], (int)x_list[i], (int)y_list[i], GameEngine.LAYER_4, 150, PitCountList[i] ); 	
}
//-------------------------------------------------------------------------------------
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

public class BlockGameEngine extends GameObject
{
	//-------------------------------------------------------------------------------------	
	public static final int MAX_PLAY_FIELD_LAYERS = 4;
	public static final int STANDARD_SHAPE_TYPES_CAP = 7;
	public final static int MAX_SHAPE_TYPES = 50;	 
	public static int LayersCap = 2;
	public static int ShapeTypesCap = 7;  		
	public static int ChallengeShapeTypesCap = 15;
	public static int TraditionalShapeTypesCap = 7;
	public static int TotalRandomFlag = 0;
			
	public static final int CELL_WIDTH_PIXELS = 20;
	public static final int CELL_HEIGHT_PIXELS = 20;
	
	public static final int STYLE_PRIMITIVE = 1;
	public static final int STYLE_PICTURE = 2;
	
	protected BlockShape[] BlockShapeList;
	protected static int CurrentGameType;
	protected static int BlockDoneFallingCount;
	
	protected Random BGERandom;
	protected int[] BagRandomNumberList;
	protected int BagRandomNumberListIndex;
	protected static int BagRandomNumberListLength;
	
	public static final int MAX_FALL_DELAY = 50;
	protected static int MainFallDelay = 50;
    
	public static int GameOverFlag;

	public final static int SHAPE_WIDTH = 5;
	public final static int SHAPE_HEIGHT = 5;   
    public static int FIELD_GRID_WIDTH = GameGlobals.FIELD_GRID_WIDTH;
	public static int FIELD_GRID_HEIGHT = GameGlobals.FIELD_GRID_HEIGHT;	
	
	protected int TilePictureIndex;
	protected int TileCellStartX, TileCellStartY, TileCellStartY_1, TileCellStartY_2;
	protected int TilePixelsWidth, TilePixelsHeight;
	
	public static int x_slide_displace = 0;
	public static final int WALL_CELL = 8;

//-------------------------------------------------------------------------------------		
static void DrawCell( int cell, int x, int y, int picture_layer, int alpha_value, int nPitCount ) 
{
   if( nPitCount > 1 && cell != WALL_CELL )
   {

     GameGlobals.DrawTileImageOne( GameControl.IMAGE_TILES_FOUR_LAYER, x, y, picture_layer, alpha_value, cell-1, GameGlobals.TileImageIndex_2_CellStartY_1,
	    	CELL_WIDTH_PIXELS, CELL_HEIGHT_PIXELS);
   }
   else
   {	
	 if( cell > 8 )
		 cell = 8;
     GameGlobals.DrawTileImageOne( GameControl.IMAGE_TILES_ONE_LAYER, x, y, picture_layer, alpha_value, cell-1, GameGlobals.TileImageIndex_2_CellStartY_2,
	    	CELL_WIDTH_PIXELS, CELL_HEIGHT_PIXELS);
   }
   
}
//-------------------------------------------------------------------------------------	
static void DrawCellSpecial( int cell, int x, int y, int picture_layer, int alpha_value ) 
{

  GameGlobals.DrawTileImageOne( GameControl.IMAGE_TILES_SHADOW, x, y, picture_layer, alpha_value, cell, 0,
	   CELL_WIDTH_PIXELS, CELL_HEIGHT_PIXELS);
 
}
//-------------------------------------------------------------------------------------	
    int BagRandomNumber( int func, int UpperLimit )
    {
      int ReturnValue = 0;
      int i, x, y, z;
      
      if( func == 0 )
      {
        // initialization
        BagRandomNumberListIndex = 0;
        BagRandomNumberListLength = UpperLimit;        
        BagRandomNumberList = new int[UpperLimit];

        for( i = 0; i < UpperLimit; i++ )
             BagRandomNumberList[i] = i;
             
        for( i = 0; i < UpperLimit ; i++ )
        {
          x = BGERandom.nextInt(UpperLimit);
          y = BGERandom.nextInt(UpperLimit);
          z = BagRandomNumberList[x];
          BagRandomNumberList[x] = BagRandomNumberList[y];
          BagRandomNumberList[y] = z;
        }      
      }
      else
      if( func == 1 )
      {
        // usage        
        ReturnValue = BagRandomNumberList[BagRandomNumberListIndex];
        BagRandomNumberListIndex++;
        
        if( BagRandomNumberListIndex >= BagRandomNumberListLength )
        {
            BagRandomNumberListIndex = 0;
             
        for( i = 0; i < BagRandomNumberListLength; i++ )
        {
          x = BGERandom.nextInt(BagRandomNumberListLength);
          y = BGERandom.nextInt(BagRandomNumberListLength);
          z = BagRandomNumberList[x];
          BagRandomNumberList[x] = BagRandomNumberList[y];
          BagRandomNumberList[y] = z;
        }             
        }
      }
      
      return ReturnValue;
    }	
	//-------------------------------------------------------------------------------------
	class BlockShape extends GameObject
	{
	 public final static int SHAPE_WIDTH = 5;
	 public final static int SHAPE_HEIGHT = 5;	 
		 
     protected int Id;		
     protected int ArrayIndex;
     
   	 protected char[][] BlockData;
	 
	 protected PlayField ItsPlayField;
	 protected boolean GhostFlag;
	 protected int FallDelay;
	 protected int FallDelayCounter;
	 protected int RotateDelay;
	 protected int RotateDelayCounter;
	 protected int QuickFallDelay;
	 protected int QuickFallDelayCounter;
	 protected int HorizontalDelay;
	 protected int HorizontalDelayCounter;
	 protected int InitialGridX;
	 protected int InitialGridY;
	 
     protected int[] ColorList;
     public int DrawStyle;
     
     protected Random Rand;
     
     protected int[] NextPieceList;
     protected int NextPieceListIndex;     
     protected BlockShape NextPieceObj;
     
     protected int EnabledFlag;
     protected BlockShape[] ItsArray;
     public int VisibleFlag = 1;
     
     protected BlockGameEngine ItsBlockGameEngine = null;
     
     public int x_slide_flag = 0;     
     public int AlphaValue = 255;
     public int[] RangeList;
     
	//------------------------------------------------------------------------------------- 
     protected void DecreaseCounters()
     {  
       if( RotateDelayCounter > 0 )
    	   RotateDelayCounter--;
       if( QuickFallDelayCounter > 0 )
    	   QuickFallDelayCounter--;
       if( HorizontalDelayCounter > 0 )
    	   HorizontalDelayCounter--;
     }
 	//-------------------------------------------------------------------------------------      
	 public BlockShape()
	 {
	   super();
	   BlockData = new char[SHAPE_WIDTH][SHAPE_HEIGHT];	
	   ItsPlayField = null;
	   GhostFlag = false;
	   FallDelay = MainFallDelay;
	   FallDelayCounter = FallDelay;
	   
	   RotateDelay = 4;
	   RotateDelayCounter = 4;
	   QuickFallDelay = 8;
	   QuickFallDelayCounter = 8;
	   HorizontalDelay = 4;
	   HorizontalDelayCounter = 4;	   

	   //** specific for android STB **
/*       
	   RotateDelay = 8;
	   RotateDelayCounter = 8;
	   QuickFallDelay = 8;
	   QuickFallDelayCounter = 8;
	   HorizontalDelay = 8; 
	   HorizontalDelayCounter = 8; 
*/ 
	   
	   DrawStyle = STYLE_PICTURE;	   
       Rand = new Random();
       
	  int i;
      ColorList = new int[MAX_SHAPE_TYPES + 1];
           
      for( i = 0; i < MAX_SHAPE_TYPES + 1; i++ )
        ColorList[i] = Color.rgb(i * 10 + 10, i * 10 + 10, i * 10 + 10);
     
      ColorList[0] = Color.BLACK;
      ColorList[1] = Color.RED;
      ColorList[2] = Color.BLUE;
      ColorList[3] = Color.GREEN;
      ColorList[4] = Color.CYAN;
      ColorList[5] = Color.MAGENTA;
      ColorList[6] = Color.LTGRAY;      
      ColorList[7] = Color.YELLOW; 
      
      NextPieceList = new int[MAX_SHAPE_TYPES];
      NextPieceListIndex = 0;
      NextPieceObj = null;
      ArrayIndex = 0;
      EnabledFlag = 1;
      ItsArray = null;
      
      RangeList = new int[4];
      RangeList[0] = -1;
	 }
	//------------------------------------------------------------------------------------- 
	public void Init( int StartGridX, int StartGridY, PlayField pf, boolean bGhostFlag, int nFallDelay,
		BlockShape NextPieceObjAttach, int nArrayIndex, BlockShape[] pItsArray,
		BlockGameEngine pBlockGameEngine ) 
	{
     ArrayIndex = nArrayIndex;
	 GridX = StartGridX; GridY = StartGridY;
	 InitialGridX = StartGridX; InitialGridY = StartGridY;
	 ItsPlayField = pf;
	 GhostFlag = bGhostFlag;
	 FallDelay = nFallDelay;
	 NextPieceObj = NextPieceObjAttach;
	 ItsArray = pItsArray;
	 //GenerateRandomShapeBagMethod();	
	 GenerateRandomShape();
	 ItsBlockGameEngine = pBlockGameEngine;
	}
	//-------------------------------------------------------------------------------------
	public void CopyNextBlockShapeList()
	{
	  int i;
	  
	  for( i = 0; i < LayersCap; i++ )
	   {
  	    TheNextBlockShape[i].CopyBlock( NextPieceObj ); 
  	    ThePlayBlockShape[i].CopyBlock( this );
  	    ThePlayBlockShape[i].RefreshBlock();
  	    TheNextBlockShape[i].RefreshBlock();
	   }
	}
	//-------------------------------------------------------------------------------------
    public void ChooseNextBlockLayer()
    {
      int Index, i;
      int NextIndex = -1;
      
      Index = Rand.nextInt(LayersCap);	
      
      for( i = 0; i < LayersCap; i++ )
      {
    	  if( TheNextBlockShape[i].EnabledFlag > 0 )
    		  NextIndex = i;
    		  
    	  ThePlayBlockShape[i].EnabledFlag = 0;
          TheNextBlockShape[i].EnabledFlag = 0;                  
      }
      
      if( NextIndex == -1 )
    	  NextIndex = 0;
      
      ThePlayBlockShape[NextIndex].EnabledFlag = 1;
      TheNextBlockShape[Index].EnabledFlag = 1;
    }
	//-------------------------------------------------------------------------------------    
    public void SetFallDelay( int nFallDelay )
    {
      FallDelay = nFallDelay;
    }
	//-------------------------------------------------------------------------------------	
	protected void Rebirth()
	{		
	  GridX = InitialGridX;
	  GridY = InitialGridY;	 
	  FallDelayCounter = 0;
	  QuickFallDelayCounter = QuickFallDelay;
	  
	  if( NextPieceObj != null )
	  {		
		CopyBlock(NextPieceObj);
		//NextPieceObj.GenerateRandomShapeBagMethod();
		NextPieceObj.GenerateRandomShape();
/*			
		 if( CurrentGameType == GameGlobals.GAME_TYPE_ORIGINAL )
*/
		if( CurrentGameType == GameGlobals.GAME_TYPE_ORIGINAL ||
			CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE )
		 {		  	 		
		   	 ChooseNextBlockLayer();
		   	 CopyNextBlockShapeList();
		 }		 
	  }
	  VisibleFlag = 1;

	}
	//-------------------------------------------------------------------------------------
	protected int SharePieceLayers()
	{
	  // the cells of the shape is shared evenly among different layers	

	  int x, y, i, Index, Index2;
	  char Cell;
	  int ActiveCellCount = 0;
	  int UselessShapeCount = 0;
	  
	  int MAX_CELLS = 10;
	  int[] FilledCellX = new int[MAX_CELLS];
	  int[] FilledCellY = new int[MAX_CELLS];
	  int FilledCellCount = 0;
	  
	  for( y = 0; y < SHAPE_HEIGHT; y++ )
	    for( x = 0; x < SHAPE_WIDTH; x++ )
	    {
/*	    	
	      Cell = ItsArray[0].BlockData[x][y];
	      
	      for( i = 0; i < LayersCap; i++ )
	        ItsArray[i].BlockData[x][y] = 0;
	    
	      if( Cell > 0 )
	      {
	        Index = BagRandomNumber( 1, LayersCap );
	        ItsArray[Index].Id = Cell;
	        ItsArray[Index].BlockData[x][y] = (char)(ItsArray[Index].ArrayIndex + 1);
	      }
*/
	      
	      Cell = ItsArray[0].BlockData[x][y];	

	      for( i = 1; i < LayersCap; i++ )
		    	ItsArray[i].BlockData[x][y] = 0;	      
	      
	      if( Cell > 0 )
	      {	    	  		      
		      for( i = 1; i < LayersCap; i++ )
			    	ItsArray[i].BlockData[x][y] = (char)(ItsArray[i].ArrayIndex + 1);

		      FilledCellX[FilledCellCount] = x;
		      FilledCellY[FilledCellCount] = y;		      
		      FilledCellCount++;
		      /*
	    	 Index = BagRandomNumber( 1, LayersCap );  
	    	 ItsArray[Index].Id = Cell;
	    	 ItsArray[Index].BlockData[x][y] = 0;
	    	 */
	      }
	    }		
	 
	  for( i = 0; i < LayersCap; i++ )
	  {
		Index = BGERandom.nextInt(LayersCap);
		Index2 = BGERandom.nextInt(FilledCellCount);
		ItsArray[i].BlockData[ FilledCellX[Index2] ][ FilledCellY[Index2] ] = 0;
	  }
	  
      for( i = 0; i < LayersCap; i++ )
      {
    	for( y = 0; y < SHAPE_HEIGHT; y++ )
    	  for( x = 0; x < SHAPE_WIDTH; x++ )
    		if( ItsArray[i].BlockData[x][y] > 0 )
    		   ActiveCellCount++;
    	
    	if( ActiveCellCount <= 0 )
    		UselessShapeCount++;
      }
      return UselessShapeCount;
	}
	//-------------------------------------------------------------------------------------
	protected void GenerateRandomShape()
	{
	   int lower = 1, upper = 2;
	   
	  if( CurrentGameType == GameGlobals.GAME_TYPE_ORIGINAL )
	  {	  
		  lower = 1; upper = ShapeTypesCap;
	  }
	  else
	  if( CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE )
	  {
		  lower = 1; upper = ChallengeShapeTypesCap;		 
	  }
	  else
	  if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )
	  {
          lower = 1; upper = TraditionalShapeTypesCap;
	  }
	  
	  GenerateShape( GameGlobals.PowerRandom( lower, upper, 2, 3 ));
	}
	//-------------------------------------------------------------------------------------	
	protected void GenerateRandomShapeBagMethod()
	{
	  int x, y, z, i;
	  int upper, lower, r;	  
	  int nShapeTypesCap = 0;
	  
	  TotalRandomFlag = GameGlobals.UseClassicRandomMethodFlag;

	  if( CurrentGameType == GameGlobals.GAME_TYPE_ORIGINAL )
		  nShapeTypesCap = ShapeTypesCap;
	  else
	  if( CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE )
		  nShapeTypesCap = ChallengeShapeTypesCap;		  
	  else
	  if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )
          nShapeTypesCap = TraditionalShapeTypesCap;
	  
	  if( NextPieceListIndex >= nShapeTypesCap )
		  NextPieceListIndex = 0;
	  
	  if( NextPieceListIndex == 0 )
	  {
		 for( i = 0; i < nShapeTypesCap; i++ )
		  NextPieceList[i] = i + 1;
		 
		 for( i = 0; i < nShapeTypesCap; i++ )
		 {
			x = Rand.nextInt(nShapeTypesCap);	
			y = Rand.nextInt(nShapeTypesCap);
			z = NextPieceList[x];
			NextPieceList[x] = NextPieceList[y];
			NextPieceList[y] = z;			
		 }
	  }
	  
	  if( CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE )
	  {
/*		  
		if( ArrayIndex != 0 )	  			
	      GenerateShape( ItsArray[0].Id );
		else
  		 {
            if( TotalRandomFlag > 0 )
            {
			  upper = 17;	lower = 1;
			  r =  Rand.nextInt(upper - lower + 1) + lower;
			  GenerateShape(r);				
            }
            else
			  GenerateShape( NextPieceList[NextPieceListIndex] );
		 }
		
		if( ArrayIndex == LayersCap - 1)
			SharePieceLayers();
*/		
			 if( TotalRandomFlag > 0 )
	         {
				  upper = nShapeTypesCap;	lower = 1;
				  r =  Rand.nextInt(upper - lower + 1) + lower;
				  GenerateShape(r);				
	         }			 
			 else
			 GenerateShape( NextPieceList[NextPieceListIndex]);		  
		  
	  }	  
	  else		  
	  if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )
	  {

        if( TotalRandomFlag > 0 )
        {
 		  upper = nShapeTypesCap + 20;	lower = 21;
		  r =  Rand.nextInt(upper - lower + 1) + lower;
		  GenerateShape(r);
        }
        else
		  GenerateShape( NextPieceList[NextPieceListIndex]  + 20 );
	  }		
	  else
	  {
  	    
		 if( TotalRandomFlag > 0 )
         {
			  upper = nShapeTypesCap;	lower = 1;
			  r =  Rand.nextInt(upper - lower + 1) + lower;
			  GenerateShape(r);				
         }			 
		 else
		 GenerateShape( NextPieceList[NextPieceListIndex]);
	  }
	    NextPieceListIndex++;

	}
	//-------------------------------------------------------------------------------------	
	protected void GenerateShape( int nId )
	{		
	  int x, y, i, k;
	  
	  if( !( 1 <= nId && nId <= MAX_SHAPE_TYPES ))
		  return;
	  
	  String[][] slist = new String[MAX_SHAPE_TYPES + 1][SHAPE_HEIGHT];

	  slist[0][ 0] = ".....";
      slist[0][ 1] = ".....";
      slist[0][ 2] = ".....";
      slist[0][ 3] = ".....";
      slist[0][ 4] = ".....";
/*	  
	  slist[0][ 0] = ".....";
      slist[0][ 1] = ".....";
      slist[0][ 2] = ".....";
      slist[0][ 3] = ".....";
      slist[0][ 4] = ".....";
	  
	  slist[1][ 0] = ".....";
      slist[1][ 1] = "..#..";
      slist[1][ 2] = ".###.";
      slist[1][ 3] = ".....";
      slist[1][ 4] = ".....";

      slist[2][ 0] = ".....";
      slist[2][ 1] = ".##..";
      slist[2][ 2] = "..##.";
      slist[2][ 3] = ".....";
      slist[2][ 4] = ".....";

      slist[3][ 0] = ".....";
      slist[3][ 1] = "..##.";
      slist[3][ 2] = ".##..";
      slist[3][ 3] = ".....";
      slist[3][ 4] = ".....";

      slist[4][ 0] = ".....";
      slist[4][ 1] = "..#..";
      slist[4][ 2] = "..#..";
      slist[4][ 3] = ".##..";
      slist[4][ 4] = ".....";

      slist[5][ 0] = ".....";
      slist[5][ 1] = "..#..";
      slist[5][ 2] = "..#..";
      slist[5][ 3] = "..##.";
      slist[5][ 4] = ".....";

      slist[6][ 0] = ".....";
      slist[6][ 1] = "..#..";
      slist[6][ 2] = "..#..";
      slist[6][ 3] = "..#..";
      slist[6][ 4] = "..#..";

      slist[7][ 0] = ".....";
      slist[7][ 1] = ".##..";
      slist[7][ 2] = ".##..";
      slist[7][ 3] = ".....";
      slist[7][ 4] = ".....";
      
	  slist[8][ 0] = ".....";
      slist[8][ 1] = ".#.#.";
      slist[8][ 2] = "..#..";
      slist[8][ 3] = ".....";
      slist[8][ 4] = ".....";

	  slist[9][ 0] = ".....";
      slist[9][ 1] = ".....";
      slist[9][ 2] = ".###.";
      slist[9][ 3] = "..#..";
      slist[9][ 4] = ".....";
      
	  slist[10][ 0] = ".....";
      slist[10][ 1] = "..#..";
      slist[10][ 2] = "..##.";
      slist[10][ 3] = ".#...";
      slist[10][ 4] = ".....";
      
	  slist[11][ 0] = ".....";
      slist[11][ 1] = ".....";
      slist[11][ 2] = ".###.";
      slist[11][ 3] = ".....";
      slist[11][ 4] = ".....";      

	  slist[12][ 0] = ".....";
      slist[12][ 1] = ".....";
      slist[12][ 2] = ".#.#.";
      slist[12][ 3] = ".....";
      slist[12][ 4] = ".....";

	  slist[13][ 0] = ".....";
      slist[13][ 1] = "...#.";
      slist[13][ 2] = "..#..";
      slist[13][ 3] = ".....";
      slist[13][ 4] = ".....";
      
	  slist[14][ 0] = ".....";
      slist[14][ 1] = "..#..";
      slist[14][ 2] = "..##.";
      slist[14][ 3] = ".....";
      slist[14][ 4] = ".....";
      
	  slist[15][ 0] = ".....";
      slist[15][ 1] = ".....";
      slist[15][ 2] = ".##..";
      slist[15][ 3] = ".....";
      slist[15][ 4] = ".....";   
*/      
	  slist[1][ 0] = ".....";
      slist[1][ 1] = "..#..";
      slist[1][ 2] = "..##.";
      slist[1][ 3] = ".....";
      slist[1][ 4] = ".....";

      slist[2][ 0] = ".....";
      slist[2][ 1] = "..#..";
      slist[2][ 2] = ".##..";
      slist[2][ 3] = ".....";
      slist[2][ 4] = ".....";

      slist[3][ 0] = ".....";
      slist[3][ 1] = "..#..";
      slist[3][ 2] = "..#..";
      slist[3][ 3] = ".....";
      slist[3][ 4] = ".....";

      slist[4][ 0] = ".....";
      slist[4][ 1] = "..#..";
      slist[4][ 2] = ".##..";
      slist[4][ 3] = ".##..";
      slist[4][ 4] = ".....";

      slist[5][ 0] = ".....";
      slist[5][ 1] = ".###.";
      slist[5][ 2] = ".##..";
      slist[5][ 3] = ".....";
      slist[5][ 4] = ".....";

      slist[6][ 0] = ".....";
      slist[6][ 1] = ".##..";
      slist[6][ 2] = ".#...";
      slist[6][ 3] = ".##..";
      slist[6][ 4] = ".....";

      slist[7][ 0] = ".....";
      slist[7][ 1] = ".....";
      slist[7][ 2] = "#####";
      slist[7][ 3] = ".....";
      slist[7][ 4] = ".....";
      
	  slist[8][ 0] = ".....";
      slist[8][ 1] = ".#.#.";
      slist[8][ 2] = "..#..";
      slist[8][ 3] = ".....";
      slist[8][ 4] = ".....";

	  slist[9][ 0] = ".....";
      slist[9][ 1] = ".....";
      slist[9][ 2] = ".###.";
      slist[9][ 3] = ".###.";
      slist[9][ 4] = ".....";
      
	  slist[10][ 0] = ".....";
      slist[10][ 1] = ".###.";
      slist[10][ 2] = ".###.";
      slist[10][ 3] = ".###.";
      slist[10][ 4] = ".....";
      
	  slist[11][ 0] = ".....";
      slist[11][ 1] = ".##..";
      slist[11][ 2] = "...#.";
      slist[11][ 3] = ".....";
      slist[11][ 4] = ".....";      

	  slist[12][ 0] = ".....";
      slist[12][ 1] = ".....";
      slist[12][ 2] = ".###.";
      slist[12][ 3] = ".....";
      slist[12][ 4] = ".....";

	  slist[13][ 0] = ".....";
      slist[13][ 1] = ".....";
      slist[13][ 2] = "..#..";
      slist[13][ 3] = ".....";
      slist[13][ 4] = ".....";
      
	  slist[14][ 0] = ".....";
      slist[14][ 1] = "..#..";
      slist[14][ 2] = "..#..";
      slist[14][ 3] = "..#..";
      slist[14][ 4] = ".....";
      
	  slist[15][ 0] = ".....";
      slist[15][ 1] = "...#.";
      slist[15][ 2] = ".##..";
      slist[15][ 3] = ".....";
      slist[15][ 4] = ".....";      
      
      k = 0;
      for( i = 16; i <= 35; i++ )
      {
       slist[i][ 0] = "#####";
       slist[i][ 1] = "#####";
       slist[i][ 2] = "#####";
       slist[i][ 3] = "#####";
       slist[i][ 4] = "#####";  
       k++;
      }
            
      char ch;
      Id = nId;

      int Cell;

      if( LayersCap > 1 )
          Cell = ArrayIndex + 1;
      else
      {
          if( Id < 0 )
        	  Id = 1;
          else
          if( Id > ChallengeShapeTypesCap )
        	  Id = ChallengeShapeTypesCap;
          
          Cell = Id % (STANDARD_SHAPE_TYPES_CAP + 1);
          
          if( Cell < 1 )
        	  Cell = 1;
          else
          if( Cell > STANDARD_SHAPE_TYPES_CAP )
        	  Cell = STANDARD_SHAPE_TYPES_CAP;          

      }
      
      for( y = 0; y < SHAPE_HEIGHT; y++ )
       for( x = 0; x < SHAPE_WIDTH; x++ )
       {
    	 ch = slist[Id][y].charAt(x);
    	 
    	 if( ch == '#')
    		 BlockData[x][y] = (char)Cell;
    	 else
    	 if( ch == '.')
    		 BlockData[x][y] = 0; 
       }      
	}
	//------------------------------------------------------------------------------------- 
	protected void RefreshBlock()
	{
	  int Cell, x, y;
	  	  
	      if( LayersCap > 1 )
	          Cell = ArrayIndex + 1;
	      else
	      {
	          Cell = Id % (STANDARD_SHAPE_TYPES_CAP + 1);

            if( Cell < 1 )
        	    Cell = 1;
            else
            if( Cell > STANDARD_SHAPE_TYPES_CAP )
        	    Cell = STANDARD_SHAPE_TYPES_CAP; 
	      }

	      for( y = 0; y < SHAPE_HEIGHT; y++ )
	       for( x = 0; x < SHAPE_WIDTH; x++ )	
	    	 if( BlockData[x][y] != 0)
	    		 BlockData[x][y] = (char)Cell;
	          		
	}
	//------------------------------------------------------------------------------------- 	
	protected void CopyBlock( BlockShape src )
	{
       Id = src.Id;
   	   int x, y;
	  
       for( y = 0; y < SHAPE_HEIGHT; y++ )
          for( x = 0; x < SHAPE_WIDTH; x++ )
              BlockData[x][y] = src.BlockData[x][y];  
	}
	//------------------------------------------------------------------------------------- 	
	public void CopyBlockShapeData( BlockShape dest, BlockShape src )
	{		
	  int x, y;
	  
	      for( y = 0; y < SHAPE_HEIGHT; y++ )
	          for( x = 0; x < SHAPE_WIDTH; x++ )    	  	          
	             dest.BlockData[x][y] = src.BlockData[x][y];  
	      
	      dest.X = src.X;
	      dest.Y = src.Y;
	      dest.GridX = src.GridX;
	      dest.GridY = src.GridY;	      
	      dest.Id = src.Id;
	      dest.ItsPlayField = src.ItsPlayField;
	      dest.GhostFlag = src.GhostFlag;
	      dest.FallDelay = src.FallDelay;
	      dest.FallDelayCounter = src.FallDelayCounter;
	      dest.ColorList = src.ColorList;	
	}
	//------------------------------------------------------------------------------------- 	
	public void CopyBlockShapeDataDeep( BlockShape dest, BlockShape src )
	{	
		CopyBlockShapeData( dest, src );
		
		dest.EnabledFlag = src.EnabledFlag;
	    dest.ArrayIndex = src.ArrayIndex;
	    dest.NextPieceObj = src.NextPieceObj;
	    
	}
	//------------------------------------------------------------------------------------- 
	protected boolean CheckCollidePlayField()
	{
      boolean returnflag = false;
      char Cell = 0;
      int x, y, x2, y2, i;
      
      if( ItsPlayField == null )
    	  return returnflag;
      
      for( y = 0; y < SHAPE_HEIGHT; y++ )
       for( x = 0; x < SHAPE_WIDTH; x++ )
       {
    	 x2 = this.GridX + x;
    	 y2 = this.GridY + y;
    	 
    	 Cell = BlockData[x][y];
    	 
    	 if( Cell > 0 && 0 <= x2 && x2 < ItsPlayField.FIELD_GRID_WIDTH &&
    		 0 <= y2 && y2 < ItsPlayField.FIELD_GRID_HEIGHT )
    	   if( ItsPlayField.BlockData[x2][y2] > 0 )
    	   {
    		  returnflag = true;
    		  break;
    	   }
       }
   
      return returnflag;
	}
	//------------------------------------------------------------------------------------- 	
	public void RotateRight() 
	{
		  if( GhostFlag )
			  return;
	
		  if( RotateDelayCounter > 0 )
		      return;
		  
		  RotateDelayCounter = RotateDelay;
	  
	  BlockShape bs2 = new BlockShape();
	  int x, y, x2, y2;
	  
	  //if( Id == SHAPE_O && CurrentGameType == GameGlobals.GAME_TYPE_ORIGINAL )
/*	  
	  if( Id == SHAPE_O )
		  return;
*/
          CopyBlockShapeData( bs2, this );
 
      
      x2 = 0;
      for( y = 0; y < SHAPE_HEIGHT; y++ )
      {   
    	  y2 = SHAPE_HEIGHT - 1;
          for( x = 0; x < SHAPE_WIDTH; x++ )
          {
            BlockData[x][y] = bs2.BlockData[x2][y2];
            y2 = y2 - 1;
          }
          x2 = x2 + 1;
      }	  	   
      
      if( CheckCollidePlayField() )
      {
    	 PlaySound(0);
      	 CopyBlockShapeData( this, bs2 );   
      }
      
      QuickFallTest();
	}
	//------------------------------------------------------------------------------------- 
	public void RotateLeft() 
	{
		  if( GhostFlag )
			  return;		
		  
		  if( RotateDelayCounter > 0 )
		      return;
		  
		  RotateDelayCounter = RotateDelay;
		      
		  BlockShape bs2 = new BlockShape();
		  int x, y, x2, y2;
		  
		  //if( Id == SHAPE_O && CurrentGameType == GameGlobals.GAME_TYPE_ORIGINAL  )
/*		  
		  if( Id == SHAPE_O )
			  return;
*/		  
	          CopyBlockShapeData( bs2, this );
	      
	      x2 = SHAPE_WIDTH - 1;
	      for( y = 0; y < SHAPE_HEIGHT; y++ )
	      {   
	    	  y2 = 0;
	          for( x = 0; x < SHAPE_WIDTH; x++ )
	          {
	            BlockData[x][y] = bs2.BlockData[x2][y2];
	            y2 = y2 + 1;
	          }
	          x2 = x2 - 1;	          
	      }	 

	      if( CheckCollidePlayField() )
	      {
	    	 PlaySound(0);
	      	 CopyBlockShapeData( this, bs2 );   
	      }
	      
	     QuickFallTest();
      
	} 
	//------------------------------------------------------------------------------------- 
	public void MoveLeft() 
	{						  
	  if( GhostFlag )
		  return;
	  
	  if( HorizontalDelayCounter > 0 )
	      return;
	  
	  HorizontalDelayCounter = HorizontalDelay;
	  
		  BlockShape bs2 = new BlockShape();
 		  CopyBlockShapeData( bs2, this );	
	      this.GridX--;
	      if( CheckCollidePlayField() )
	      {
	    	 PlaySound(0);
	      	 CopyBlockShapeData( this, bs2 );   
	      }	
	      
	      QuickFallTest();
	} 
	//------------------------------------------------------------------------------------- 
	public void MoveRight() 
	{		  
		  if( GhostFlag )
			  return;
		  
		  if( HorizontalDelayCounter > 0 )
		      return;
		 
		  HorizontalDelayCounter = HorizontalDelay;
		  
		  BlockShape bs2 = new BlockShape();
 		  CopyBlockShapeData( bs2, this );	
	      this.GridX++;
	      if( CheckCollidePlayField() )
	      {
	    	 PlaySound(0);
	      	 CopyBlockShapeData( this, bs2 );   
	      }	
	      
	     QuickFallTest();
	}
	//------------------------------------------------------------------------------------- 
	protected boolean Fall()
	{
	  boolean ReachBottomFlag = false;	  
	  
	  if( FallDelayCounter > 0 )
	  {
		  FallDelayCounter--;
	      return ReachBottomFlag;
	  }
	  FallDelayCounter = FallDelay;	  
	  	  
		 BlockShape bs2 = new BlockShape();
 		 CopyBlockShapeData( bs2, this );	
 		  
		 this.GridY++;		
		 
	      if( CheckCollidePlayField() )
	      {	    		    	  
		    CopyBlockShapeData( this, bs2 );
		    
		    ReachBottomFlag = true;
		    
		    if( !GhostFlag )
		      PasteBlockPlayField(); 
		    PlaySound(1);
		    
		    GameGlobals.Add2CurrentScore(0);
		    
		    x_slide_displace = 0;
	      }		   
	      
	     QuickFallTest();  
	  
	  return ReachBottomFlag;
	}
	//-------------------------------------------------------------------------------------
	protected void GroupRebirth()
	{
		int i;
		for( i = 0; i < LayersCap; i++ )
		{
		  ThePlayBlockShape[i].Rebirth();
		  ThePlayBlockShape[i].EnabledFlag = 1;
 		  ThePlayBlockShape[i].VisibleFlag = 1;
		}
		
		BlockDoneFallingCount = 0;	
	}
	//-------------------------------------------------------------------------------------
    public void MakeNewPiece()
    {
     if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )
     {
  	  BlockDoneFallingCount++;
  	  EnabledFlag = 0;
  					
  	  if( BlockDoneFallingCount >= LayersCap  )
  		  GroupRebirth();
      }
      else			 
        Rebirth();
     
     QuickFallTest();
    }
	//-------------------------------------------------------------------------------------
	public void QuickFall() 
	{		
		  if( QuickFallDelayCounter > 0 )			
              return;
		  if( ItsPlayField.LineClearAnimationCounter < 255 )
			  return;
		  
		  GameGlobals.Add2CurrentScore(0);
		  
		  QuickFallDelayCounter = QuickFallDelay;
		  PlaySound(1);
 		  int y, grid_y_top = this.GridY;
 		  
 		  for( y = 0; y < BlockGameEngine.FIELD_GRID_HEIGHT; y++ )
 		  { 			  
 			  this.GridY++;
 			  
 		      if( CheckCollidePlayField() )
 		      { 		    	 		    	 
 			    this.GridY--;
 			    
 			    ItsBlockGameEngine.CreateFallWoosh( ArrayIndex, this,  grid_y_top, GridY );
 			    
 			    if( !GhostFlag )
 			    { 	
 			      PasteBlockPlayField(); 	
  			      ItsPlayField.LinesYClearArray = ItsPlayField.CheckFormLinesB();


                  if( ItsPlayField.LinesYClearArray.length >= 1 )
                  {
                      ItsPlayField.LineClearAnimationCounter = 0;
                      ItsPlayField.ClearLinesFlag = 1;
                      VisibleFlag = 0;
                  }
                  else
                    MakeNewPiece();
 			    }
   			    break;
 		      } 			  	 
 		  }
 		  
 		  x_slide_displace =  0;		  
	}
	//------------------------------------------------------------------------------------- 
	public void QuickFallTest()
	{
 		  int y, grid_y_top = this.GridY;
 		  
 		  for( y = 0; y < BlockGameEngine.FIELD_GRID_HEIGHT; y++ )
 		  { 			  
 			  this.GridY++;
 			  
 		      if( CheckCollidePlayField() )
 		      { 		    	 		    	 
 			    this.GridY--; 		
 			    GetBlockXYCoordinates( RangeList );
   			    break;
 		      } 			  	 
 		  }	
 		  
 		  this.GridY = grid_y_top;
	}
	//------------------------------------------------------------------------------------- 
	protected void GetBlockXYCoordinates( int rangelist[] )
	{
	   int x, y, breakflag;
	   	  
	  // top
	   breakflag = 0;
	  for( y = 0; y < SHAPE_HEIGHT; y++ )
	  {
	   for( x = 0; x < SHAPE_WIDTH; x++ )
	   {
		 if( this.BlockData[x][y] > 0 )
		 {
			 rangelist[0] = GridY + y;
			 breakflag = 1;
			 break;
		 }
	   }
	   if( breakflag >= 1 )
		   break;
	  }
	  
	  // bottom
	  breakflag = 0;
	  for( y = SHAPE_HEIGHT - 1; y >= 0; y-- )
	  {
	   for( x = 0; x < SHAPE_WIDTH; x++ )
	   {
		 if( this.BlockData[x][y] > 0 )
		 {
			 rangelist[1] = GridY + y;
			 breakflag = 1;
			 break;
		 }
	   }
	   if( breakflag >= 1 )
		   break;
	  }	  
	  
	  // left
	   breakflag = 0;
	  for( x = 0; x < SHAPE_WIDTH; x++ )
	  {
	   for( y = 0; y < SHAPE_HEIGHT; y++ )
	   {
		 if( this.BlockData[x][y] > 0 )
		 {
			 rangelist[2] = GridX + x;
			 breakflag = 1;
			 break;
		 }
	   }
	   if( breakflag >= 1 )
		   break;
	  }	  
	  
	  // left
	   breakflag = 0;
	  for( x = SHAPE_WIDTH - 1; x >= 0; x-- )
	  {
	   for( y = 0; y < SHAPE_HEIGHT; y++ )
	   {
		 if( this.BlockData[x][y] > 0 )
		 {
			 rangelist[3] = GridX + x;
			 breakflag = 1;
			 break;
		 }
	   }
	   if( breakflag >= 1 )
		   break;
	  }		  
	 
	}
	//------------------------------------------------------------------------------------- 	
	protected void PasteBlockPlayField() 
	{		
	  int x, y, x2, y2;
	  
	  for( y = 0; y < SHAPE_HEIGHT; y++ )
	   for( x = 0; x < SHAPE_WIDTH; x++ )
	   {
		 x2 = this.GridX + x;
		 y2 = this.GridY + y;
		 
		 if( this.BlockData[x][y] > 0 && 0 <= x2 && x2 < ItsPlayField.FIELD_GRID_WIDTH &&
			 0 <= y2 && y2 < ItsPlayField.FIELD_GRID_HEIGHT )
			 ItsPlayField.BlockData[x2][y2] = this.BlockData[x][y];
	   }
	}
	//-------------------------------------------------------------------------------------	
	public void Do() 
	{
	  if( x_slide_flag >= 1  )	
	  {	  
	   if( GameGlobals.CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )
	   {
		 if( ItsPlayField.ArrayIndex == 0 )
           x_slide_displace -= 5;
	   }
	   else
		 x_slide_displace -= 5;
	   
        if( GridX * TilePixelsWidth + x_slide_displace < -SHAPE_WIDTH * TilePixelsWidth )
        	x_slide_displace = 0;
	  }
	  
	 if( !GhostFlag )
	 {	 
	  if( GridY == InitialGridY )
      {
		if( CheckCollidePlayField())
		{
			GameOverFlag = 1;
			return;
		}
      }

      if( ItsPlayField.LineClearAnimationCounter < 255 )
          ItsPlayField.LineClearAnimationCounter += PlayField.LineClearAnimationCounterIncrement;
      else
      if( ItsPlayField.ClearLinesFlag == 1 )
      {
          ItsPlayField.ShiftBlocksDown( ItsPlayField.LinesYClearArray );
          ItsPlayField.ClearLinesFlag = 0;
          ItsPlayField.LinesYClearArray = null;      
          MakeNewPiece();
      }	  
      else 
   	  if( Fall() )
   	  {
   		PasteBlockPlayField();  
  		ItsPlayField.LinesYClearArray = ItsPlayField.CheckFormLinesB();        
        
         if( ItsPlayField.LinesYClearArray.length >= 1 )
          {
             ItsPlayField.LineClearAnimationCounter = 0;
             ItsPlayField.ClearLinesFlag = 1;
             VisibleFlag = 0;
          }
         else
           MakeNewPiece();
   	  }
 	  DecreaseCounters();
	 }
	}
	//-------------------------------------------------------------------------------------	
	public void Draw() 
	{		
	  int x, y; 
	  float fX, fY;
      char Cell;
      
      if( VisibleFlag == 0 )
    	  return;
      
          float WIDTH = CELL_WIDTH_PIXELS/2;
          float HEIGHT = CELL_HEIGHT_PIXELS/2;

          float XShift = 0, YShift = 0;
       
          if( ArrayIndex == 0 )
          {
            XShift = 0; YShift = 0; 
          }
          else
          if( ArrayIndex == 1 )
          {
            XShift = 1; YShift = 0; 
          }
          else
          if( ArrayIndex == 2 )
          {
            XShift = 0; YShift = 1; 
          }
          else
          if( ArrayIndex == 3 )
          {
            XShift = 1; YShift = 1; 
          }	  
          XShift *= WIDTH;
          YShift *= HEIGHT;
	 
	 if( DrawStyle == STYLE_PRIMITIVE )
	 {		 
	  int c_color; 

      for( y = 0; y < SHAPE_HEIGHT; y++ )
		for( x = 0; x < SHAPE_WIDTH; x++ )
		   if( BlockData[x][y] > 0  )
		   {	 
			   fX = (GridX + x) * CELL_WIDTH_PIXELS + x_slide_displace; 
			   fY = (GridY + y) * CELL_HEIGHT_PIXELS;

			   c_color = ColorList[BlockData[x][y]];
			       
			 if( ArrayIndex < LayersCap )  
			   GE.DrawBox( fX, fY, fX+CELL_WIDTH_PIXELS, fY+CELL_HEIGHT_PIXELS, GE.LAYER_2, c_color, 
					    GameEngine.G_STYLE_STROKE );
			   
			   GE.DrawBox( fX+XShift, fY+YShift, fX+XShift+WIDTH, fY+YShift+HEIGHT, 
					     GE.LAYER_3, c_color,GameEngine.G_STYLE_FILL );		

/*			   
			   GE.DrawBox( fX, fY, fX+CELL_WIDTH_PIXELS, fY+CELL_HEIGHT_PIXELS, GE.LAYER_3, ColorList[BlockData[x][y]], 
					    GameEngine.G_STYLE_FILL );
*/					    
		   }
	 }
	 else
     if( DrawStyle == STYLE_PICTURE )
     {
    	 
         for( y = 0; y < SHAPE_HEIGHT; y++ )
     		for( x = 0; x < SHAPE_WIDTH; x++ )
     		   if( BlockData[x][y] > 0  )
     		   {     			   
	     		   Cell = BlockData[x][y];
	     		   
	     		   if( Cell > 0  )
	     		   {
	     			   if( x_slide_flag >= 1 )
	    			      fX = (GridX + x) * CELL_WIDTH_PIXELS + x_slide_displace; 
	     			   else
	     				   fX = (GridX + x) * CELL_WIDTH_PIXELS;
	     			   
	    			   fY = (GridY + y) * CELL_HEIGHT_PIXELS;
	    			   
                       DrawCell( Cell, (int)fX, (int)fY, GE.LAYER_3, AlphaValue, LayersCap );  			   
    				
	     		   }     			   
     		   }
         
         if( RangeList[0] > -1 && ( ThePlayerControls.MSB_State == ArrayIndex || CurrentGameType != GameGlobals.GAME_TYPE_TRADITIONAL ))
         {
/*        	 
        	x = ItsPlayField.LEFT_WALL_X;
        	for( y = RangeList[0]; y <= RangeList[1]; y++ )
        	{
        		fX = x * CELL_WIDTH_PIXELS;
        		fY = y * CELL_HEIGHT_PIXELS;
        		DrawCellSpecial( ArrayIndex, (int)fX, (int)fY, GE.LAYER_4, 100 );  	
        	}
        	
        	x = ItsPlayField.RIGHT_WALL_X;
        	for( y = RangeList[0]; y <= RangeList[1]; y++ )
        	{
        		fX = x * CELL_WIDTH_PIXELS;
        		fY = y * CELL_HEIGHT_PIXELS;
        		DrawCellSpecial( ArrayIndex, (int)fX, (int)fY, GE.LAYER_4, 100 );  	
        	}
*/        	
        	y = ItsPlayField.BOTTOM_WALL_Y;
        	for( x = RangeList[2]; x <= RangeList[3]; x++ )
        	{
        		fX = x * CELL_WIDTH_PIXELS;
        		fY = y * CELL_HEIGHT_PIXELS;
        		DrawCellSpecial( ArrayIndex, (int)fX, (int)fY, GE.LAYER_4, 100 );  	
        	}        	
         }
     }
	 
	}
	//-------------------------------------------------------------------------------------		
	}
//-------------------------------------------------------------------------------------
class QuickFallBlockShape extends BlockShape
{
public final static int LIFE_COUNTER_MAX = 10;
protected int LifeCounter = LIFE_COUNTER_MAX;
public int ActiveFlag = 1;
protected int Y_Top, Y_Bottom;

//-------------------------------------------------------------------------------------
public void Init( int nY_Top, int nY_Bottom )
{
	if( nY_Top < 0 )
		nY_Top = 0;
	
	Y_Top = nY_Top; Y_Bottom = nY_Bottom;
}
//-------------------------------------------------------------------------------------
public void Do()
{
   if( LifeCounter <= 0 )
     ActiveFlag = 0;
   else
     LifeCounter--;
   
}
//-------------------------------------------------------------------------------------
public boolean Fall() { return false; }
public void GroupRebirth() {}
public void Rebirth() {} 
//-------------------------------------------------------------------------------------
public void Draw()
{
	  int x, y, i;
	  float fX, fY, alpha = 255f, alpha_percent = 0.90f;
      char Cell;           

  for( i = Y_Bottom; i >= Y_Top; i-- )
  {  
     GridY = i;
     alpha = alpha * alpha_percent * (LifeCounter+0.0f)/LIFE_COUNTER_MAX;
     
         for( y = 0; y < SHAPE_HEIGHT; y++ )
     		for( x = 0; x < SHAPE_WIDTH; x++ )
     		   if( BlockData[x][y] > 0  )
     		   {     			   
	     		   Cell = BlockData[x][y];
	     		   
	     		   if( Cell > 0  )
	     		   {
	    			   fX = (GridX + x) * CELL_WIDTH_PIXELS; 
	    			   fY = (GridY + y) * CELL_HEIGHT_PIXELS;
	    			   
                       DrawCell( Cell, (int)fX, (int)fY, GE.LAYER_3, (int)alpha, LayersCap ); 			        				
	     		   }     			
                }
   }

}	
}
//-------------------------------------------------------------------------------------	
	class PlayerControls extends GameObject
	{
	   BlockShape[] BlockShapeList;
	   int BlockShapeListCount;
       Button[] ButtonList;
       MultiStateButton MultiStateButton_1;
       
       protected static final int BUTTON_ROTATE_LEFT = 0;
       protected static final int BUTTON_ROTATE_RIGHT = 1;
       protected static final int BUTTON_MOVE_LEFT = 2;
       protected static final int BUTTON_MOVE_RIGHT = 3;
       protected static final int BUTTON_HARD_DROP = 4;
       protected static final int MAX_BUTTONS = 5;
       
       public static final int UNIQUE_ID_BUTTON_ROTATE_LEFT = 200;
       public static final int UNIQUE_ID_BUTTON_ROTATE_RIGHT = 201;
       public static final int UNIQUE_ID_BUTTON_LEFT = 202;
       public static final int UNIQUE_ID_BUTTON_RIGHT = 203;
       public static final int UNIQUE_ID_BUTTON_DROP = 204;
       public static final int UNIQUE_ID_BUTTON_SWITCH_LAYER = 205;
       
       public int InputDelayCounter, InputDelayCounterMax;       
       
       public int MSB_State;
       
	   //-------------------------------------------------------------------------------------
	   public PlayerControls()
	   {
		 super();
		 Button Button1;
		 MouseEventNotifyFlag = true;
		 KeyEventNotifyFlag = true;
		 BlockShapeListCount = 0;
		 BlockShapeList = new BlockShape[MAX_PLAY_FIELD_LAYERS];
		 ButtonList = new Button[MAX_BUTTONS];
		 
		 int x_spacing = 60;
		 int x_start = 5;
		 
		 if( GameGlobals.CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )
			 x_spacing = 52;
		 

         Button1 = new Button( "RL", 0,0,0,0 );
	     Button1.Create_WidthxHeight( x_start, 420 + 10, 48, 48, GameGlobals.GROUP_ID_NONE, UNIQUE_ID_BUTTON_ROTATE_LEFT, GE.LAYER_2, GE.LAYER_1, 
         GameControl.IMAGE_TILES_1x1, 14, 19, 255 );	  
	     Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
         ButtonList[BUTTON_ROTATE_LEFT] = Button1; 
         
         Button1 = new Button( "RR", 0,0,0,0 );
	     Button1.Create_WidthxHeight( x_start + x_spacing * 1, 420 + 10, 48, 48, GameGlobals.GROUP_ID_NONE, UNIQUE_ID_BUTTON_ROTATE_RIGHT, GE.LAYER_2, GE.LAYER_1, 
         GameControl.IMAGE_TILES_1x1, 15, 19, 255 );	  
	     Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
         ButtonList[BUTTON_ROTATE_RIGHT] = Button1;          
		 
         Button1 = new Button( "<", 0,0,0,0 );
	     Button1.Create_WidthxHeight( x_start + x_spacing * 2, 420 + 10, 48, 48, GameGlobals.GROUP_ID_NONE, UNIQUE_ID_BUTTON_LEFT, GE.LAYER_2, GE.LAYER_1, 
         GameControl.IMAGE_TILES_1x1, 12, 19, 255 );	  
	     Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
         ButtonList[BUTTON_MOVE_LEFT] = Button1;   
          
         Button1 = new Button( ">", 0,0,0,0 );
	     Button1.Create_WidthxHeight( x_start + x_spacing * 3, 420 + 10, 48, 48, GameGlobals.GROUP_ID_NONE, UNIQUE_ID_BUTTON_RIGHT, GE.LAYER_2, GE.LAYER_1, 
         GameControl.IMAGE_TILES_1x1, 13, 19, 255 );	  
	     Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
         ButtonList[BUTTON_MOVE_RIGHT] = Button1;

        Button1 = new Button( "\\/", 0,0,0,0 );
	    Button1.Create_WidthxHeight( x_start + x_spacing * 4, 420 + 10, 48, 48, GameGlobals.GROUP_ID_NONE, UNIQUE_ID_BUTTON_DROP, GE.LAYER_2, GE.LAYER_1, 
        GameControl.IMAGE_TILES_1x1, 10, 19, 255 );	  
	    Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
        ButtonList[BUTTON_HARD_DROP] = Button1;
      
		 int i;
		 for( i = 0; i < MAX_BUTTONS; i++ )
		 {
		   ButtonList[i].MouseEventNotifyFlag = true;
		   ButtonList[i].InputDelayMax = 0;
		   ButtonList[i].InputDelayCounter = 0;		   
		 }


/*		 
		 MultiStateButton_1 = new MultiStateButton( PicList, null, null, null, 
				264, 364, 48, 48, 4, 20 );
*/
		 
       MultiStateButton_1 = new MultiStateButton( x_start + x_spacing * 5, 420 + 10, 48,48, GameGlobals.GROUP_ID_NONE, 
    		   UNIQUE_ID_BUTTON_SWITCH_LAYER,
            GE.LAYER_2, GE.LAYER_1, 10, GameControl.IMAGE_TILES_1x1, GameGlobals.InterfaceStyleIndex, 0, 255);
       MultiStateButton_1.MouseEventNotifyFlag = true;
       MultiStateButton_1.SetMaxStates( LayersCap );  	
		 
		 InputDelayCounterMax = 5; 
		 InputDelayCounter = InputDelayCounterMax;
	   }
	 //-------------------------------------------------------------------------------------	   
	   public void AddBlockShape( BlockShape bs )
	   {		   
		  BlockShapeList[BlockShapeListCount] = bs;
		  BlockShapeListCount++;
	   }
	 //-------------------------------------------------------------------------------------	   
	   public void OnClick()
	   {
          int i;
          for( i = 0; i < MAX_BUTTONS; i++ )
        	   ButtonList[i].OnClick();
          MultiStateButton_1.OnClick();
	   }
     //-------------------------------------------------------------------------------------		   
	   public void OnKey()
	   {
		  int i;
		  MSB_State = MultiStateButton_1.GetButtonState();
		  
		  int YesFlag = 0;
		  
		  if( InputDelayCounter == InputDelayCounterMax )
		  {
		      YesFlag = 1;
		      InputDelayCounter = 0;
		  }
		  
		  switch(KeyCode)
		  {
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:	
            	
		    	   if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )
		    	   {
		    		  if( GameGlobals.TVModeFlag > 0 )
		    		  {
		       		    if( YesFlag > 0 )
            	          MultiStateButton_1.InstantClick();
		    		  }
		    		  else
		            	  BlockShapeList[MSB_State].RotateLeft();
		    	   }
		           else
		           {
			          for( i = 0; i < BlockShapeListCount; i++ )
			    	    BlockShapeList[i].RotateLeft();	            	            	
		           }
              break;
            case KeyEvent.KEYCODE_S:
                 
             if( YesFlag > 0 )
             {
            	   MSB_State = MultiStateButton_1.GetButtonState();
                   MSB_State++;
                   if( MSB_State >= LayersCap )
                       MSB_State = 0;
                   MultiStateButton_1.SetButtonState(MSB_State);
             }
		    	   break;            	
            case KeyEvent.KEYCODE_D:
		    	   if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	
		            	 BlockShapeList[MSB_State].RotateLeft();
		             else 		    	
			       for( i = 0; i < BlockShapeListCount; i++ )
			    	   BlockShapeList[i].RotateLeft();	
		    	   break;
            case KeyEvent.KEYCODE_F: 	
		    	   if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	
		            	 BlockShapeList[MSB_State].RotateRight();
		             else 		    	
			       for( i = 0; i < BlockShapeListCount; i++ )
			    	   BlockShapeList[i].RotateRight();	
		    	   break;
		    case KeyEvent.KEYCODE_DPAD_UP:		      
/*		    	
	             if( (CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL) ||		             
		                 (CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE ))
*/	            	 
		    	   if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	
		            	 BlockShapeList[MSB_State].RotateRight();
		             else 		    	
			       for( i = 0; i < BlockShapeListCount; i++ )
			    	   BlockShapeList[i].RotateRight();		
			   break;
		    case KeyEvent.KEYCODE_DPAD_DOWN:
			       for( i = 0; i < BlockShapeListCount; i++ )
			    	    BlockShapeList[i].QuickFall();		    	
			   break;
		    case KeyEvent.KEYCODE_DPAD_LEFT:	
		    	
		    	if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	
		        {
		          BlockShapeList[MSB_State].MoveLeft();
		        }		    	
		    	else
			     for( i = 0; i < BlockShapeListCount; i++ )
			    	  BlockShapeList[i].MoveLeft();		    	
			   break;
		    case KeyEvent.KEYCODE_DPAD_RIGHT:
		    	
		    	 if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	
		    	 {
		            	 BlockShapeList[MSB_State].MoveRight();
		    	  }
		    	 else
			     for( i = 0; i < BlockShapeListCount; i++ )
			    	  BlockShapeList[i].MoveRight();	
			   break;    
			default:
			   break;
		  }
	    }
		//-------------------------------------------------------------------------------------		
		public void Draw()
		{
			int k;
			
		    if( GameGlobals.TVModeFlag == 0 )
			  for( k = 0; k < MAX_BUTTONS; k++ )
			    ButtonList[k].Draw();	
			  
	     //if( CurrentGameType != GameGlobals.GAME_TYPE_ORIGINAL )	  
	      if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	  
			  MultiStateButton_1.Draw();  
		}
		//-------------------------------------------------------------------------------------		
		public void Do()
		{
		  int k, i;
		  Button but;
		  
		  if( InputDelayCounter < InputDelayCounterMax )
		      InputDelayCounter++;
		  		  
		  MSB_State = MultiStateButton_1.GetButtonState();
		  MultiStateButton_1.Do();
		  
		  for( k = 0; k < MAX_BUTTONS; k++ )
		  {
		    UniqueId = ButtonList[k].UniqueId;
		    but = ButtonList[k];
		    but.Do();

		    if( but.MouseStatus_Dup == but.ME_PRESS_DOWN ||
		    	but.MouseStatus_Dup == but.ME_MOVE )
		    { 
		      switch(UniqueId)
		      {		  
		         case UNIQUE_ID_BUTTON_ROTATE_LEFT:
/*		        	 
		             if( (CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL) ||		             
		                 (CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE ))
*/
		        	 if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )		        	 
		             {		            	
		            	 BlockShapeList[MSB_State].RotateLeft();
		             }
		             else 
				       for( i = 0; i < BlockShapeListCount; i++ )
				    	   BlockShapeList[i].RotateLeft();	
				       break;
		         case UNIQUE_ID_BUTTON_ROTATE_RIGHT:

/*		        	 
		             if( (CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL) ||		             
			             (CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE ))
*/		            	 
		        	   if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )		        	 
			             {		            	
			            	 BlockShapeList[MSB_State].RotateRight();
			             }
			             else 		        	 
				       for( i = 0; i < BlockShapeListCount; i++ )
				    	   BlockShapeList[i].RotateRight();
				       break;
		         case UNIQUE_ID_BUTTON_LEFT:
		        	 
			    	 if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	
			    	 {
			            	 BlockShapeList[MSB_State].MoveLeft();
			    	  }
			    	 else		        	 
				       for( i = 0; i < BlockShapeListCount; i++ )
				    	   BlockShapeList[i].MoveLeft();			        	 
				       break;
		         case UNIQUE_ID_BUTTON_RIGHT:
		        	 
			    	 if( CurrentGameType == GameGlobals.GAME_TYPE_TRADITIONAL )	
			    	  {
			            	 BlockShapeList[MSB_State].MoveRight();
			    	  }
			    	 else		        	 
				       for( i = 0; i < BlockShapeListCount; i++ )
				    	   BlockShapeList[i].MoveRight();	
				       break;
		         case UNIQUE_ID_BUTTON_DROP:
				       for( i = 0; i < BlockShapeListCount; i++ )
				    	    BlockShapeList[i].QuickFall();
				       break;
		         default:
		           break;
		      }
		    }
		    else
		    if( but.MouseStatus_Dup == but.ME_RELEASE )
		    {
		       but.ClearDupInput();	
		    }		  
		    but.ClearDupInput();	
		}
		  
	   if( MultiStateButton_1.MouseStatus_Dup == GameObject.ME_PRESS_DOWN )
	   {
		   
	   }
	   else
	   if( MultiStateButton_1.MouseStatus_Dup == GameObject.ME_RELEASE )
	   {
		   
	   }
		    	
     	 // SwitchBlockShapeListLayer();
/*
*   int CurrentBlockShapeListLayer = 0;
*   
void SwitchBlockShapeListLayer()
{
CurrentBlockShapeListLayer++;
}		        	 
*/     
			  
	   }
	//-------------------------------------------------------------------------------------			
	}
	//-------------------------------------------------------------------------------------
	class PlayField extends GameObject
	{		
	  public final int FIELD_GRID_WIDTH = BlockGameEngine.FIELD_GRID_WIDTH;
	  public final int FIELD_GRID_HEIGHT = BlockGameEngine.FIELD_GRID_HEIGHT;
      public static final int MAX_LINES_FORMED_COUNT = 10;
	  public char[][] BlockData;

      public int DrawStyle;
      public int ArrayIndex;      
      protected int[] ColorList;
      
      public int LineClearAnimationCounter = 255;
      public int ClearLinesFlag = 0;
      public final static int LineClearAnimationCounterMax = 255;
      public final static int LineClearAnimationCounterIncrement = 25;  
      public int[] LinesYClearArray = null;
      public int[] LinesYClearArrayFullSize = new int[FIELD_GRID_HEIGHT];
      
      public final int LEFT_WALL_X = 0;
      public final int RIGHT_WALL_X = BlockGameEngine.FIELD_GRID_WIDTH - 1;
      public final int BOTTOM_WALL_Y = BlockGameEngine.FIELD_GRID_HEIGHT - 1;
      
	//-------------------------------------------------------------------------------------
	  public PlayField()
	  {		 
		super();		
		
	    BlockData = new char[FIELD_GRID_WIDTH][FIELD_GRID_HEIGHT];	    
	    int x, y;
	    
        // *** create the boundaries ***
	    for( y = 0; y < FIELD_GRID_HEIGHT; y++ )
	    {
	      BlockData[LEFT_WALL_X][y] = 8;  	
	      BlockData[RIGHT_WALL_X][y] = 8; 
	    }
	    for( x = 0; x < FIELD_GRID_WIDTH; x++ )
	    	 BlockData[x][BOTTOM_WALL_Y] = 8;
	    
	    DrawStyle = STYLE_PICTURE;

      ColorList = new int[MAX_SHAPE_TYPES + 1];
      
      int i;
      for( i = 0; i < MAX_SHAPE_TYPES + 1; i++ )
        ColorList[i] = Color.rgb(i * 10 + 10, i * 10 + 10, i * 10 + 10);
     
      ColorList[0] = Color.BLACK;
      ColorList[1] = Color.RED;
      ColorList[2] = Color.BLUE;
      ColorList[3] = Color.GREEN;
      ColorList[4] = Color.CYAN;
      ColorList[5] = Color.MAGENTA;
      ColorList[6] = Color.LTGRAY;      
      ColorList[7] = Color.YELLOW;    
      ArrayIndex = 0;
	  }
	//-------------------------------------------------------------------------------------
	  public int CheckFormLines()
	  {	
        int[] LinesY = new int[MAX_LINES_FORMED_COUNT];
        int LinesYCount;
        int x, y, i, CellCount;
        
        LinesYCount = 0;
        
        for( y = FIELD_GRID_HEIGHT - 2; y > 0; y-- )
        {
          CellCount = 0;
          
          for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
             if( BlockData[x][y] > 0 )
                 CellCount++;

          if( CellCount >= FIELD_GRID_WIDTH - 2 )
          {            
            LinesY[LinesYCount] = y;          
            LinesYCount = LinesYCount + 1;
          }                                 
        }
        
        for( i = 0; i < LinesYCount; i++ )
         for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
           BlockData[x][ LinesY[i]] = 0;
           
        for( i = 0; i < LinesYCount; i++ )
         for( y = FIELD_GRID_HEIGHT - 2; y >= 1; y-- )
         { 
          CellCount = 0;
      
          for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
           if( BlockData[x][y] > 0 )
              CellCount++;
      
          if( CellCount == 0 )
          {
            for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
            {
              BlockData[x][y] = BlockData[x][y-1];
              BlockData[x][y-1] = 0;
            }
          }
      
         }          
                
        if( LinesYCount > 0 )
           PlaySound(2);
        
        GameGlobals.Add2CurrentScore( LinesYCount );
        
        if( LinesYCount > 0 )
        	SetSpeed();
      
        return LinesYCount;
	  }
	//-------------------------------------------------------------------------------------
    public int[] CheckFormLinesB()
    {    
        int[] LinesY = new int[MAX_LINES_FORMED_COUNT];
        int LinesYCount;
        int x, y, i, CellCount, f;
        
        LinesYCount = 0;
        //String str ="";
        
        for( y = FIELD_GRID_HEIGHT - 2; y > 0; y-- )
        {
          CellCount = 0;
          
          for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
             if( BlockData[x][y] > 0 )
                 CellCount++;

          if( CellCount >= FIELD_GRID_WIDTH - 2 )
          {            
            LinesY[LinesYCount] = y;          
            LinesYCount = LinesYCount + 1;
            //str += y + ",";
            
            for( f = 1; f <= FIELD_GRID_WIDTH - 2; f++ )
            	ParabolicCells.CurrentObj.Add( BlockData[f][y], f * CELL_WIDTH_PIXELS, y * CELL_HEIGHT_PIXELS, LayersCap );
          }                                 
        } 
        
       for( i = 0; i < FIELD_GRID_HEIGHT; i++ )
        	LinesYClearArrayFullSize[i] = 0;
                
        int[] LinesY_B = new int[LinesYCount];
        
        for( i = 0; i < LinesYCount; i++ )
        {
        	 LinesY_B[i] = LinesY[i];
        	 LinesYClearArrayFullSize[ LinesY_B[i] ] = 1;
        }
      
        return LinesY_B;
    }
	//-------------------------------------------------------------------------------------
    public void ShiftBlocksDown( int[] LinesY )
    {    	
    	int i, x, y, LinesYCount = LinesY.length, CellCount;
    	
        for( i = 0; i < LinesYCount; i++ )
         for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
          if( BlockData[x][LinesY[i]] != WALL_CELL )
           BlockData[x][ LinesY[i]] = 0;
           
        for( i = 0; i < LinesYCount; i++ )
         for( y = FIELD_GRID_HEIGHT - 2; y >= 1; y-- )
         { 
          CellCount = 0;
      
          for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
           if( BlockData[x][y] > 0 )
        	 if( BlockData[x][LinesY[i]] != WALL_CELL )   
              CellCount++;
      
          if( CellCount == 0 )
          {
            for( x = 1; x <= FIELD_GRID_WIDTH - 2; x++ )
            if( BlockData[x][y] != WALL_CELL )	
            {
              BlockData[x][y] = BlockData[x][y-1];
              BlockData[x][y-1] = 0;
            }
          }
      
         }          
                
        if( LinesYCount > 0 )
           PlaySound(2);
        
        GameGlobals.Add2CurrentScore( LinesYCount );    	
    }
	//-------------------------------------------------------------------------------------	  
		public void Draw() 
		{		
		  int x, y; 
		  float fX, fY;
          char Cell;
          
	          float WIDTH = CELL_WIDTH_PIXELS/2;
	          float HEIGHT = CELL_HEIGHT_PIXELS/2;

	          float XShift = 0, YShift = 0;
	       
	          if( ArrayIndex == 0 )
	          {
	            XShift = 0; YShift = 0; 
	          }
	          else
	          if( ArrayIndex == 1 )
	          {
	            XShift = 1; YShift = 0; 
	          }
	          else
	          if( ArrayIndex == 2 )
	          {
	            XShift = 0; YShift = 1; 
	          }
	          else
	          if( ArrayIndex == 3 )
	          {
	            XShift = 1; YShift = 1; 
	          }	  
	          XShift *= WIDTH;
	          YShift *= HEIGHT;
		 
		 if( DrawStyle == STYLE_PRIMITIVE )
		 {		 

		  int c_color, c_color_random; 
			  
		  c_color_random = Color.rgb( BGERandom.nextInt(255), BGERandom.nextInt(255), BGERandom.nextInt(255) );
		  
	      for( y = 0; y < FIELD_GRID_HEIGHT; y++ )
	       {
	        if( LinesYClearArrayFullSize[y] > 0 )
	            c_color_random = Color.rgb( BGERandom.nextInt(255), BGERandom.nextInt(255), BGERandom.nextInt(255) );
	    	  
			for( x = 0; x < FIELD_GRID_WIDTH; x++ )
			   if( BlockData[x][y] > 0  )
			   {	 				   
				   fX = x * CELL_WIDTH_PIXELS; 
				   fY = y * CELL_HEIGHT_PIXELS;

			   if( LineClearAnimationCounter < LineClearAnimationCounterMax )			   
			   	   c_color = c_color_random;			   	   			   
			   else
				   c_color = ColorList[BlockData[x][y]];
			   
				 if( ArrayIndex < LayersCap )  
				   GE.DrawBox( fX, fY, fX+CELL_WIDTH_PIXELS, fY+CELL_HEIGHT_PIXELS, GE.LAYER_1, c_color , 
						    GameEngine.G_STYLE_STROKE );
				   
				   GE.DrawBox( fX+XShift, fY+YShift, fX+XShift+WIDTH, fY+YShift+HEIGHT, 
						     GE.LAYER_2, c_color,GameEngine.G_STYLE_FILL );			   

	/*			   
				   GE.DrawBox( fX, fY, fX+CELL_WIDTH_PIXELS, fY+CELL_HEIGHT_PIXELS, GE.LAYER_3, ColorList[BlockData[x][y]], 
						    GameEngine.G_STYLE_FILL );
	*/					    
			   }
	       }
		 }
		 else
	     if( DrawStyle == STYLE_PICTURE )
	     {
	    	 int alpha;
        
	         for( y = 0; y < FIELD_GRID_HEIGHT; y++ )
	         {
	        	if( LineClearAnimationCounter < LineClearAnimationCounterMax && LinesYClearArrayFullSize[y] > 0 )
	        	{
	        		alpha = 255 - LineClearAnimationCounter;
	        		if( alpha < 0 )
	        			alpha = 0;
	        	}
	            else
	        	    alpha = 255;
	        	
	     		for( x = 0; x < FIELD_GRID_WIDTH; x++ )
	     		{	
	     		   Cell = BlockData[x][y];
	     		   
	     		   if( Cell > 0  )
	     		   {
	    			   fX = (GridX + x) * CELL_WIDTH_PIXELS; 
	    			   fY = (GridY + y) * CELL_HEIGHT_PIXELS;

	    			   DrawCell( Cell, (int)fX, (int)fY, GE.LAYER_3, alpha, LayersCap ); 	    			   
     				
	     		   }
	     		}
	         }
	     }
		 
		}	  
	//-------------------------------------------------------------------------------------	    
	}
	//-------------------------------------------------------------------------------------
    class InfoDisplay
    {	   
	   protected Caption ItsCaption;
	  
	 //-------------------------------------------------------------------------------------
	   public InfoDisplay()
	   {		  
		 int x, y, fontsize = GameGlobals.RegularFontSize1;
		 y = GameGlobals.FIELD_GRID_HEIGHT * CELL_HEIGHT_PIXELS + CELL_HEIGHT_PIXELS;
		 x = GameGlobals.CELL_WIDTH_PIXELS/2;
/*				 
		 ItsCaption = new Caption( 250, 148, "" );  
		 ItsCaption.SetTextOptions( 20, Color.rgb(255,255,0), 0, 0, true, 40 );
*/

		 ItsCaption = new Caption( x, y, "" ); 
		 ItsCaption.SetTextOptions( fontsize, Color.rgb(255,255,0), 0, 0, true, CELL_HEIGHT_PIXELS );
		 
		 ItsCaption.TextLayer = GameEngine.LAYER_3;
		 ItsCaption.UniqueId = GameGlobals.UNIQUE_ID_CAPTION_GENERAL;
		 ControlManager.SetGameObjectUniqueImage( (GameObject)ItsCaption );
	   }
	 //-------------------------------------------------------------------------------------
	   public void Draw()
	   {		  
		 String s = new String("");
/*		 
		 s += "Score\n" + GameGlobals.CurrentPlayerScore + "\n"; 
		 s += "Speed\n" + GameGlobals.GameSpeed + "\n";
		 s += "Lines\n" + GameGlobals.CurrentLineCount + "\n";
*/		 
		 s += "Score " +  GameGlobals.SetMinTextWidthLeft( "" + GameGlobals.CurrentPlayerScore, " ", 7 ); 
		 s += " Speed " + GameGlobals.GameSpeed + " ";
		 s += " Beams " + GameGlobals.CurrentLineCount + " ";
		 
		 ItsCaption.SetText(s);
		 ItsCaption.Draw();
		 
	   }
	 //-------------------------------------------------------------------------------------
	   public void Do()
	   {		  
	   }
	 //-------------------------------------------------------------------------------------
    }	
	//-------------------------------------------------------------------------------------		
	  protected static PlayField[] ThePlayField;
	  protected static BlockShape[] ThePlayBlockShape;
	  protected static BlockShape[] TheNextBlockShape;
     	  	  
	  protected PlayerControls ThePlayerControls; // up, down, left, rotate left, rotate right, score, speed, etc.
	  protected InfoDisplay TheInfoDisplay;
	  
	  QuickFallBlockShape[] QuickFallBlockShapeList = new QuickFallBlockShape[MAX_PLAY_FIELD_LAYERS];
	  
    //-------------------------------------------------------------------------------------	  
	public BlockGameEngine()
	{		
		super();

		//* * * * * * * * * * * * * * * * * * * * * * *
		
        CurrentGameType = GameGlobals.CurrentGameType;
        LayersCap = GameGlobals.PitCount;
        MainFallDelay = MAX_FALL_DELAY - GameGlobals.GameSpeed * 2;
        
        //* * * * * * * * * * * * * * * * * * * * * * *
        
        TilePictureIndex = 50;
        TilePixelsWidth = TilePixelsHeight = 20;
        TileCellStartX = 0;
        TileCellStartY = 0;
        TileCellStartY_1 = 9;
        TileCellStartY_2 = 9;
        
      //* * * * * * * * * * * * * * * * * * * * * * *
        
        GameOverFlag = 0;
        
		ClassType[TYPE_BLOCK_GAME_ENGINE] = 1;
		Name = new String("BlockGameEngine");
		
		MouseEventNotifyFlag = true;
		KeyEventNotifyFlag = true;		 
		int i;
		
		BGERandom = new Random();
		BagRandomNumber( 0, LayersCap );
					
        ThePlayField = new PlayField[MAX_PLAY_FIELD_LAYERS];
        ThePlayBlockShape = new BlockShape[MAX_PLAY_FIELD_LAYERS];
        TheNextBlockShape = new BlockShape[MAX_PLAY_FIELD_LAYERS];       
        ThePlayerControls = new PlayerControls();
        
        for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )
        {
          ThePlayField[i] = new PlayField();          
          ThePlayBlockShape[i] = new BlockShape();
          TheNextBlockShape[i] = new BlockShape();
          
          TheNextBlockShape[i].x_slide_flag = 1;
          TheNextBlockShape[i].AlphaValue = 255/2;
          
          ThePlayField[i].ArrayIndex = i;          
          ThePlayerControls.AddBlockShape(ThePlayBlockShape[i]);
        }               
        
        for( i = 0; i < LayersCap; i++ )
        {
         ThePlayBlockShape[i].Init( 4, -1, ThePlayField[i], false, MainFallDelay, TheNextBlockShape[i], i, ThePlayBlockShape, this ) ;
         TheNextBlockShape[i].Init( 11, 2, ThePlayField[i], true, MainFallDelay, null, i, TheNextBlockShape, this ) ;
        }
        
        BlockDoneFallingCount = 0;     
                        		
   	    if( CurrentGameType == GameGlobals.GAME_TYPE_ORIGINAL )
   	    {
    	    ThePlayBlockShape[0].CopyNextBlockShapeList();        
    	    ThePlayBlockShape[0].ChooseNextBlockLayer();
   	    }	    
   	    else
		if( CurrentGameType == GameGlobals.GAME_TYPE_CHALLENGE )
		{
/*
			ThePlayBlockShape[0].SharePieceLayers();
			TheNextBlockShape[0].SharePieceLayers();
*/			
    	    ThePlayBlockShape[0].CopyNextBlockShapeList();        
    	    ThePlayBlockShape[0].ChooseNextBlockLayer();			
		}	   	    

   	    TheInfoDisplay = new InfoDisplay();
   	    
   	 if( GameGlobals.GarbageBlocksFlag > 0 )
   		CreateGarbageCells();
   	    
   	 if( GameGlobals.LoadGameFileFlag > 0 )
   		RetrieveGameDataGlobals();
   	 
     for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )
       QuickFallBlockShapeList[i] = null;   	 
	}
	//-------------------------------------------------------------------------------------
	protected void RetrieveGameDataGlobals()
	{		
		int i, x, y;
        for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )
        {
        	ThePlayBlockShape[i].Id = GameGlobals.GameSaveData[i].BlockShape_Id;
            ThePlayBlockShape[i].GridX = GameGlobals.GameSaveData[i].BlockShape_GridX;
            ThePlayBlockShape[i].GridY = GameGlobals.GameSaveData[i].BlockShape_GridY;
        	ThePlayBlockShape[i].EnabledFlag = GameGlobals.GameSaveData[i].BlockShape_EnabledFlag;
        	
	        for( y = 0; y < SHAPE_HEIGHT; y++ )
		      for( x = 0; x < SHAPE_WIDTH; x++ )  
		    	  ThePlayBlockShape[i].BlockData[x][y] = GameGlobals.GameSaveData[i].BlockShape_BlockData[x][y];

        	TheNextBlockShape[i].Id = GameGlobals.GameSaveData[i].BlockShape_Next_Id;
        	TheNextBlockShape[i].EnabledFlag = GameGlobals.GameSaveData[i].BlockShape_Next_EnabledFlag;
        	
	        for( y = 0; y < SHAPE_HEIGHT; y++ )
		      for( x = 0; x < SHAPE_WIDTH; x++ )  
		    	  TheNextBlockShape[i].BlockData[x][y] = GameGlobals.GameSaveData[i].BlockShape_Next_BlockData[x][y];
	        
	        for( y = 0; y < FIELD_GRID_HEIGHT; y++ )
		      for( x = 0; x < FIELD_GRID_WIDTH; x++ ) 
		    	  ThePlayField[i].BlockData[x][y] = GameGlobals.GameSaveData[i].PlayField_BlockData[x][y];
        }
	}
	//-------------------------------------------------------------------------------------	
	public void OnKey() 
	{		
	  ThePlayerControls.OnKey();	
	  ThePlayerControls.ClearDupInput();	  
	}
	//-------------------------------------------------------------------------------------	
	public void OnClick() 
	{		
	 if( GameGlobals.TVModeFlag == 0 )
	 {
	   ThePlayerControls.OnClick();	
	   ThePlayerControls.ClearDupInput();		
	 }
	}
	//-------------------------------------------------------------------------------------	
	public void Do()
	{		
	  int i;
	  String s = new String("");
	  
	  for( i = 0; i < LayersCap; i++ )
	  {
		 ThePlayField[i].Do();
		 
	  if( ThePlayBlockShape[i].EnabledFlag == 1 )	 
		 ThePlayBlockShape[i].Do();
	  if( TheNextBlockShape[i].EnabledFlag == 1 )	  
		 TheNextBlockShape[i].Do();		 
	  
        if( QuickFallBlockShapeList[i] != null )
        {
          QuickFallBlockShapeList[i].Do();	  
          if( QuickFallBlockShapeList[i].ActiveFlag == 0 )
        	  QuickFallBlockShapeList[i] = null;
        }
	   //s += ThePlayBlockShape[i].GridX + ", " + ThePlayBlockShape[i].GridY + ", " + ThePlayBlockShape[i].EnabledFlag + "; ";
	  }
/*	  
	  s = "GameSpeed = " + GameGlobals.GameSpeed;
	  s += "\nPitCount = " + GameGlobals.PitCount;
	  s += "\nSoundsFlag = " + GameGlobals.SoundsFlag;
	  s += "\nGarbageBlocksFlag = " + GameGlobals.GarbageBlocksFlag;
	  s += "\nBackGroundIndex = " + GameGlobals.BackGroundIndex;
	  s += "\nWorkingBackGroundIndex = " + GameGlobals.WorkingBackGroundIndex;
*/	  
	  //GameGlobals.debugcaption.SetText(s);
	  	  
	  ThePlayerControls.Do();
	  ParabolicCells.CurrentObj.Do();
	}
	//-------------------------------------------------------------------------------------	
	public void Draw() 
	{
		
	  int i;
	  for( i = 0 ; i < LayersCap; i++ )
	  {
		  if( ThePlayBlockShape[i].EnabledFlag == 1 )		  
  		   ThePlayBlockShape[i].Draw();
		  if( TheNextBlockShape[i].EnabledFlag == 1 )		  
   		   TheNextBlockShape[i].Draw();
		  
      if( QuickFallBlockShapeList[i] != null )
          QuickFallBlockShapeList[i].Draw();			  
	  }
	  
	  for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )
		   ThePlayField[i].Draw();		 
	  
	      ThePlayerControls.Draw();
	  
	  TheInfoDisplay.Draw();
	  ParabolicCells.CurrentObj.Draw();
	}
	//-------------------------------------------------------------------------------------	   
	public void SaveGameData()
	{		
	  int i;
	  
	  for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )		 
	     GameGlobals.SetPlayData( i, 
	    		 ThePlayBlockShape[i].Id,
	    		 ThePlayBlockShape[i].GridX,
	    		 ThePlayBlockShape[i].GridY,
	    		 ThePlayBlockShape[i].BlockData,
	    		 ThePlayBlockShape[i].EnabledFlag,       
	    		 TheNextBlockShape[i].Id,
	    		 TheNextBlockShape[i].BlockData,
	    		 TheNextBlockShape[i].EnabledFlag,       
	    		 ThePlayField[i].BlockData ); 	
	  
	  GameGlobals.SaveGameData();
	}
	//-------------------------------------------------------------------------------------	
	protected void CreateGarbageCells()
	{
	  char Cell;
	  int lower, upper, x, y;
	  int i;
	  
	  int StartY, EndY, StartX, EndX;
/*	    
	  upper = FIELD_GRID_HEIGHT - 5;
	  lower = FIELD_GRID_HEIGHT - 10;
	  
	  StartY = BGERandom.nextInt(upper - lower + 1) + lower;
	  EndY = FIELD_GRID_HEIGHT - 1;
	  StartX = 1; EndX = FIELD_GRID_WIDTH - 1;
	    
	  if( LayersCap > 1 )
	  {
	    lower = 1;
	    upper = LayersCap;
	  }
	  else
	  if( LayersCap == 1 )
	  {
	    lower = 1;
	    upper = 7;
	  }
	  
	  for( i = 0; i < 70; i++ )
	  {
	     Cell = (char)(BGERandom.nextInt(upper - lower + 1) + lower);
	     x = BGERandom.nextInt(EndX - StartX + 1) + StartX;
	     y = BGERandom.nextInt(EndY - StartY + 1) + StartY;
	     	    
	     if( LayersCap > 1 )
	       ThePlayField[Cell - 1].BlockData[x][y] = Cell;
	     else
	     if( LayersCap == 1 )
	       ThePlayField[0].BlockData[x][y] = Cell;
	  }
*/
	  StartX = 1; EndX = FIELD_GRID_WIDTH - 1;
	  upper = FIELD_GRID_HEIGHT - 1;
	  lower = FIELD_GRID_HEIGHT - 3;
	    
	  for( x = StartX; x <= EndX; x++ )
	  {		  
		StartY = BGERandom.nextInt(upper - lower + 1) + lower;
		EndY = FIELD_GRID_HEIGHT - 1;
		
        for( i = 0; i < LayersCap; i++ )
         for( y = StartY; y <= EndY; y++ )
           ThePlayField[i].BlockData[x][y] = WALL_CELL;
	  }
		  
	}	
	//-------------------------------------------------------------------------------------
	protected void PlaySound( int Index )
	{
		if( GameGlobals.SoundsFlag > 0 )
		{
		   GE.SoundOperationFlag = 1;
		   GE.SoundPlayIndex = Index; 
		}		
	}
	//-------------------------------------------------------------------------------------	
	protected void SetSpeed()
	{
	  MainFallDelay = MAX_FALL_DELAY - GameGlobals.GameSpeed * 2;		
	}	
	//-------------------------------------------------------------------------------------	
	public void SetOptions( int nTilePictureIndex, int nTileCellStartY_1, int nTileCellStartY_2 )
	{		
        TilePictureIndex = 50;
        TileCellStartX = 0;
        TileCellStartY = 0;
        TileCellStartY_1 = nTileCellStartY_1;
        TileCellStartY_2 = nTileCellStartY_2;		
	}
	//-------------------------------------------------------------------------------------	
    public void CreateFallWoosh( int Index, BlockShape src, int GridY_Top, int GridY_Bottom )
    {
     QuickFallBlockShapeList[Index] = new QuickFallBlockShape();
     QuickFallBlockShapeList[Index].CopyBlockShapeData( QuickFallBlockShapeList[Index], src );
     QuickFallBlockShapeList[Index].Init( GridY_Top, GridY_Bottom );
    }	
    //-------------------------------------------------------------------------------------	
}	