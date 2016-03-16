package com.parallelia;

import android.content.Context;
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
import android.graphics.Rect;
import java.util.*;

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class GameGlobals
{
	/* On/Off switches */
	public static int TVModeFlag = 0; 
	public static int PlayFieldHeightIncrease = 0;
/*
	public static int TVModeFlag = 1; 
	public static int PlayFieldHeightIncrease = 2;
*/	
	public static final int GROUP_ID_NONE = 0;
	public static final int UNIQUE_ID_NONE = 0;
	
	/* Add constants for group ids */
	public static final int GROUP_ID_MENU_A = 201;
	public static final int GROUP_ID_MENU_B = 202;
	public static final int GROUP_ID_MENU_C = 203;
	public static final int GROUP_ID_MENU_C2 = 204;
	public static final int GROUP_ID_MENU_D = 205;
	public static final int GROUP_ID_MENU_E = 206;
	public static final int GROUP_ID_MENU_F = 207;
	public static final int GROUP_ID_MENU_G = 208;
	public static final int GROUP_ID_MENU_H = 209;
	
	/* Add constants for unique ids */	
	public static final int UNIQUE_ID_BUTTON_START = 101;
	public static final int UNIQUE_ID_BUTTON_OPTIONS = 102;
	public static final int UNIQUE_ID_BUTTON_HIGH_SCORES = 103;

	public static final int UNIQUE_ID_BUTTON_GAME_ORIGINAL = 104;
	public static final int UNIQUE_ID_BUTTON_GAME_CHALLENGE = 105;
	public static final int UNIQUE_ID_BUTTON_GAME_TRADITIONAL = 106;

	public static final int UNIQUE_ID_CAPTION_OPTION_SPEED = 107;
	public static final int UNIQUE_ID_CAPTION_OPTION_PIT_COUNT = 108;	
	public static final int UNIQUE_ID_BUTTON_OPTION_INC_SPEED = 109;
	public static final int UNIQUE_ID_BUTTON_OPTION_DEC_SPEED = 110;
	public static final int UNIQUE_ID_BUTTON_OPTION_INC_PIT = 111;
	public static final int UNIQUE_ID_BUTTON_OPTION_DEC_PIT = 112;
	public static final int UNIQUE_ID_CHECKBOX_OPTION_SOUNDS = 113;
	public static final int UNIQUE_ID_CHECKBOX_OPTION_GARBAGE = 114;
	public static final int UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_1 = 115;
	public static final int UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_2 = 1150;
	public static final int UNIQUE_ID_BUTTON_OPTION_OKAY = 116;	
	public static final int UNIQUE_ID_CAPTION_HIGH_SCORES_LIST = 117;
	public static final int UNIQUE_ID_BUTTON_HIGH_SCORES_OKAY = 118;
	public static final int UNIQUE_ID_BUTTON_HIGH_SCORES_LEFT = 119;
	public static final int UNIQUE_ID_BUTTON_HIGH_SCORES_RIGHT = 120;
    public static final int UNIQUE_ID_CAPTION_GAME_OVER_NAME = 121;
	public static final int UNIQUE_ID_BUTTON_GAME_OVER_LEFT = 122;
    public static final int UNIQUE_ID_BUTTON_GAME_OVER_DOWN = 123;
    public static final int UNIQUE_ID_BUTTON_GAME_OVER_UP = 124;
    public static final int UNIQUE_ID_BUTTON_GAME_OVER_RIGHT = 125;
    public static final int UNIQUE_ID_BUTTON_GAME_OVER_OKAY = 126;
    public static final int UNIQUE_ID_BUTTON_GAME_OVER_OKAY_ADD_SCORE = 127;
    
    public static final int UNIQUE_ID_CAPTION_MAIN_TITLE = 128;
    public static final int UNIQUE_ID_CAPTION_GENERAL = 129;
    public static final int UNIQUE_ID_BLOCK_GAME_ENGINE_1 = 130;
    
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_MSB = 131;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_0 = 132;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_1 = 133;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_2 = 134;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_3 = 135;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_4 = 136;

    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_MSB = 137;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_0 = 138;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_1 = 139;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_2 = 140;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_3 = 141;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_4 = 142;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_5 = 143;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_6 = 144;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_7 = 145;
    public static final int UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_8 = 146;

    public static final int UNIQUE_ID_BUTTON_OPTION_INTERFACE_COLORS_MSB = 147;
    public static final int UNIQUE_ID_BUTTON_OPTION_INTERFACE_COLORS_CAP_0 = 148;
    public static final int UNIQUE_ID_BUTTON_OPTION_RANDOM_METHOD_MSB = 149;
    public static final int UNIQUE_ID_BUTTON_OPTION_RANDOM_METHOD_CAP_0 = 150;
        
    public static final int UNIQUE_ID_BUTTON_OPTION_RIGHT = 151;
    public static final int UNIQUE_ID_BUTTON_OPTION_LEFT = 152;
    
    public static final int UNIQUE_ID_BUTTON_ABOUT_OKAY = 153;
    public static final int UNIQUE_ID_BUTTON_ABOUT = 154;
    
    public static final int UNIQUE_ID_BUTTON_ABOUT_EULA = 155;
    public static final int UNIQUE_ID_BUTTON_ABOUT_EULA_OKAY = 156;
    public static final int UNIQUE_ID_BUTTON_ABOUT_EULA_UP = 157;
    public static final int UNIQUE_ID_BUTTON_ABOUT_EULA_DOWN = 158;
    
	public static final int MAX_BACKGROUNDS = 100;
	public static final int MIN_GAME_SPEED = 0;
	public static final int MAX_GAME_SPEED = 24;
	public static final int MAX_PIT_COUNT = 4;	
	public static final int MIN_PIT_COUNT = 1;	
	public static final int MAX_HIGH_SCORES = 10;
	public static final int MAX_HIGH_SCORE_NAME_LENGTH = 12;
	
	/* Graphics-related variables */

    public final static int CELL_WIDTH_PIXELS = 32;
    public final static int CELL_HEIGHT_PIXELS = 32;
    public final static int CELL_WIDTH_PIXELS_ENLARGED = 34;
    public final static int CELL_HEIGHT_PIXELS_ENLARGED = 34;
    protected static int CellWidthPixels = 32;
    protected static int CellHeightPixels = 32;
    protected static int CellWidthPixelsEnlarged = 34;
    protected static int CellHeightPixelsEnlarged = 34;
    
	public static int[] IMAGE;
	public final static int MAX_ALPHA = 255;    
    
	/* Add global variables here */	
    public static int GameSpeed;
    public static int PitCount;
    public static int SoundsFlag;
    public static int GarbageBlocksFlag;
    public static int BackGroundIndex;
        
    public static String[] HighScoresNames_Original;
    public static int[] HighScoresValue_Original;
    public static String[] HighScoresNames_Challenge;
    public static int[] HighScoresValue_Challenge;
    public static String[] HighScoresNames_Traditional;
    public static int[] HighScoresValue_Traditional;
    protected static int HighScoreBoardIndex;
    protected static final int HIGH_SCORE_BOARD_INDEX_MAX = 2;

    public static String CurrentPlayerName;
    protected static int CurrentPlayerNameCursorPosition;
    public static int CurrentPlayerScore;
    public static int CurrentGameType;
    public static int CurrentLineCount;
    
    public static final int GAME_TYPE_ORIGINAL = 1;
    public static final int GAME_TYPE_CHALLENGE = 2;
    public static final int GAME_TYPE_TRADITIONAL = 3;    
    
    protected static int i;
    
    public static SimpleBackGround BackDrop;
    
    /* for debugging purposes */
    public static Caption debugcaption;    
    
    public static String dummystr = new String("");
/*    
    public static int counter = 0;
*/    
    // * * * * * * * * * * * * * * * 
    
    public static GameEngine GE;       
    public static final int MAX_PLAY_FIELD_LAYERS = 4;
    public static String GameFileName;
    public static String OptionsFileName;
    
	public final static int SHAPE_WIDTH = 5;
	public final static int SHAPE_HEIGHT = 5;   
    public static int FIELD_GRID_WIDTH = 12 + 4;
	public static int FIELD_GRID_HEIGHT = 20 + PlayFieldHeightIncrease;
	   
    class BlockShape_PlayField_Data
    { 
       public int BlockShape_Id;	
  	   public int BlockShape_GridX, BlockShape_GridY;       
       public char[][] BlockShape_BlockData;
       public int BlockShape_EnabledFlag;
       
       public int BlockShape_Next_Id;	     
       public char[][] BlockShape_Next_BlockData;
       public int BlockShape_Next_EnabledFlag;
       
       public char[][] PlayField_BlockData;
       
       BlockShape_PlayField_Data()
       {
         BlockShape_BlockData = new char[SHAPE_WIDTH][SHAPE_HEIGHT];
         BlockShape_Next_BlockData = new char[SHAPE_WIDTH][SHAPE_HEIGHT];
         PlayField_BlockData = new char[FIELD_GRID_WIDTH][FIELD_GRID_HEIGHT];     
       }
    }
    
    public static int LoadGameFileFlag = 0;
    public static int LoadOptionsFileFlag = 0;
    
    public static BlockShape_PlayField_Data[] GameSaveData;
    
    // * * * * * * * * * * * * * * *     
    //*** Extra Options Variables ***
    
    public static int TileImageIndex_1 = 49;
    public static int TileImageIndex_2 = 50;
    public static int MainFontColor = Color.rgb( 255, 255, 0 );
    public static int TileImageIndex_2_CellStartY_1 = 0;
    public static int TileImageIndex_2_CellStartY_2 = 0;
    public static int UseClassicRandomMethodFlag = 0;
    public static int InterfaceStyleIndex = 0;   
    
    // * * * * * * * * * * * * * * * 
    
    public static int HeaderFontSize1 = 30;
    public static int HeaderFontSize2 = 25;
    public static int RegularFontSize1 = 20;    
    
     protected static Random rand = new Random();
     
//-------------------------------------------------------------------------------------
    public GameGlobals()
    {
        IMAGE = new int[GameControl.MAX_BITMAPS];
        
        for( i = 0; i < GameControl.MAX_BITMAPS; i++ )
      	  IMAGE[i] = i;    	     
/*    	
      CurrentGameType = GAME_TYPE_ORIGINAL;
      GameSpeed = MIN_GAME_SPEED;
      PitCount = MAX_PIT_COUNT;
*/      
      CurrentGameType = GAME_TYPE_ORIGINAL;
      GameSpeed = 5;
      PitCount = 2;
            
      SoundsFlag = 0;
      GarbageBlocksFlag = 0;
      BackGroundIndex = 0;

       // *** debug ***
/*      
	   GameEngine.CurrentObj.FileName = "closelog.txt";
	   GameEngine.CurrentObj.DoRequest(GameEngine.CurrentObj.G_REQUEST_READ_FILE);
       dummystr = new String(GameEngine.CurrentObj.FileDataStr);
       String[] templist = dummystr.split(",");
       
       if( templist.length >= 2 )
          counter = Integer.parseInt(templist[1]);
       dummystr = "program closed," + counter;
       counter++;
*/       	   
      debugcaption = new Caption(10, 50, "");
      debugcaption.SetLayers( GameEngine.CurrentObj.LAYER_3, GameEngine.CurrentObj.LAYER_2 );
      debugcaption.SetTextOptions( 10, Color.rgb(255,255,255), 0, 20, true, 20 );     

      HighScoresNames_Original = new String[MAX_HIGH_SCORES];
      HighScoresValue_Original = new int[MAX_HIGH_SCORES];

      HighScoresNames_Challenge = new String[MAX_HIGH_SCORES];
      HighScoresValue_Challenge = new int[MAX_HIGH_SCORES];

      HighScoresNames_Traditional = new String[MAX_HIGH_SCORES];
      HighScoresValue_Traditional = new int[MAX_HIGH_SCORES]; 
/*      
      for( i = 0; i < MAX_HIGH_SCORES; i++ )
      {
    	HighScoresNames_Original[i] = "------------";  
    	HighScoresValue_Original[i] = 0;
    	HighScoresNames_Challenge[i] = "------------";  
    	HighScoresValue_Challenge[i] = 0;
    	HighScoresNames_Traditional[i] = "------------";  
    	HighScoresValue_Traditional[i] = 0;
      }
*/      
      CurrentPlayerScore = 0;     
      CurrentPlayerNameCursorPosition = 0;
      CurrentLineCount = 0;
      
      BackDrop = new SimpleBackGround();
      BackDrop.SetProperties( SimpleBackGround.STYLE_PICTURE_TILED, Color.rgb(0,100,0), GameControl.IMAGE_TILES_BACKGROUND, 48, 48 );
      
      LoadGameFileFlag = 0;
      LoadOptionsFileFlag = 0;
      
      GameSaveData = new BlockShape_PlayField_Data[MAX_PLAY_FIELD_LAYERS];
      for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )
           GameSaveData[i] = new BlockShape_PlayField_Data();
           
      GameFileName = new String("gamesave.txt");   
      OptionsFileName = new String("options.txt");      
      
      String[] names = new String[MAX_HIGH_SCORES];
      names[0] = "ADAM        ";
      names[1] = "BOB         ";
      names[2] = "CRYSTAL     ";
      names[3] = "DANIEL      ";
      names[4] = "EDNA        ";
      names[5] = "FRANK       ";
      names[6] = "HOWARD      ";
      names[7] = "IMOGEN      ";
      names[8] = "JACK        ";    				      				      				  
      names[9] = "KEN         ";
      
      int k = 2000;
      
      for( i = 0; i < MAX_HIGH_SCORES; i++ )
      {    	  
    	HighScoresNames_Original[i] = names[i];
    	HighScoresValue_Original[i] = k;
    	HighScoresNames_Challenge[i] = names[i];
    	HighScoresValue_Challenge[i] = k;
    	HighScoresNames_Traditional[i] = names[i];
    	HighScoresValue_Traditional[i] = k;
    	k -= 100;
      }
    }
  //-------------------------------------------------------------------------------------
    static public void ClearSomeData()
    {
      CurrentPlayerName = new String("");
      CurrentPlayerNameCursorPosition = 0;
      CurrentPlayerScore = 0;
      CurrentLineCount = 0;
    }
//-------------------------------------------------------------------------------------
    static public void Add2CurrentScore( int LineCount )
    {
      int SpeedIncreaseFlag = 0, NewLineCount;
      final int SPEED_INCREASE_LINES = 100;
      
      CurrentPlayerScore += 10;
      
    	   if( LineCount < 0 )
    	   {	   
    	       CurrentPlayerScore = 0;
    	       CurrentLineCount = 0;
    	   }
    	   else
    	   if( LineCount >= 0 )
    	   {
             NewLineCount = CurrentLineCount + LineCount;
             
             if( NewLineCount / SPEED_INCREASE_LINES > CurrentLineCount / SPEED_INCREASE_LINES )
                 SpeedIncreaseFlag = 1;
             
    		 CurrentLineCount = NewLineCount;
    	     CurrentPlayerScore += 20 * LineCount * PitCount + GameSpeed * LineCount;

    	     if( CurrentPlayerScore > 999999 )
    	         CurrentPlayerScore = 999999;
          
             if( SpeedIncreaseFlag == 1 )
             {
    	       if( GameSpeed < MAX_GAME_SPEED )
    	    	 GameSpeed++; 
             }   
    	   }
    }  
//-------------------------------------------------------------------------------------    
    static public String SelectHighScoreBoardtoString( int IndexDirection )
    {
      HighScoreBoardIndex += IndexDirection;
      
      if( HighScoreBoardIndex > HIGH_SCORE_BOARD_INDEX_MAX )
          HighScoreBoardIndex = 0;
      if( HighScoreBoardIndex < 0 )
    	  HighScoreBoardIndex = HIGH_SCORE_BOARD_INDEX_MAX;
      
	  String scorestr = "";
	 
	if( HighScoreBoardIndex == 0 )
	{
	  scorestr += "ORIGINAL\n";			  
      for( i = 0; i < MAX_HIGH_SCORES; i++ )
    	scorestr += HighScoresNames_Original[i] + "  " +
    	HighScoresValue_Original[i] + "\n";
	}
	else
	if( HighScoreBoardIndex == 1 )
	{		
      scorestr += "CHALLENGE\n";
      for( i = 0; i < MAX_HIGH_SCORES; i++ )
    	scorestr += HighScoresNames_Challenge[i] + "  " +
    	HighScoresValue_Challenge[i] + "\n";
	}
	else
	if( HighScoreBoardIndex == 2 )
	{
      scorestr += "TRADITIONAL\n";
      for( i = 0; i < MAX_HIGH_SCORES; i++ )
    	scorestr += HighScoresNames_Traditional[i] + "  " +
    	HighScoresValue_Traditional[i] + "\n";    
	}      
      return scorestr;
   }
//-------------------------------------------------------------------------------------
static protected void Highest2Lowest( String[] sList, int[] List )
{
  int x, y, z;
  String str;
  
  for( y = 0; y < List.length; y++ )
   for( x = 0; x < List.length; x++ )
    if( List[x] < List[y] )
    {
       z = List[x];
       List[x] = List[y];
       List[y] = z;
       str = sList[x];
       sList[x] = sList[y];
       sList[y] = str;
    }
}    
//-------------------------------------------------------------------------------------
static public boolean CheckNewHighScore()
{
   boolean returnvalue = false;
   
   if( CurrentGameType == GAME_TYPE_ORIGINAL )
   {
     for( i = 0; i < MAX_HIGH_SCORES; i++ )
 	   if( CurrentPlayerScore > HighScoresValue_Original[i] )
 	   {
 	     returnvalue = true;
 	     break;
 	   }
   }
   else
   if( CurrentGameType == GAME_TYPE_CHALLENGE )
   {
       for( i = 0; i < MAX_HIGH_SCORES; i++ )
     	 if( CurrentPlayerScore > HighScoresValue_Challenge[i] )
  	     {
    	   returnvalue = true;
    	   break;
    	 }  	
   }
   else
   if( CurrentGameType == GAME_TYPE_TRADITIONAL )
   {
       for( i = 0; i < MAX_HIGH_SCORES; i++ )
        if( CurrentPlayerScore > HighScoresValue_Traditional[i] )
 	    {
   	      returnvalue = true;
   	      break;
   	    }     	
   }   
   
   return returnvalue;
}
//-------------------------------------------------------------------------------------
static public void Add2HighScore( String name )
{
  int[] HighScoresTempInt = new int[MAX_HIGH_SCORES];
  String[] HighScoresTempStr = new String[MAX_HIGH_SCORES];
  
  for( i = 0; i < MAX_HIGH_SCORES; i++ )	  
   switch(CurrentGameType)
   {
    case GAME_TYPE_ORIGINAL: 
      HighScoresTempInt[i] = HighScoresValue_Original[i];
      HighScoresTempStr[i] = HighScoresNames_Original[i];
      break;
    case GAME_TYPE_CHALLENGE:
      HighScoresTempInt[i] = HighScoresValue_Challenge[i];
      HighScoresTempStr[i] = HighScoresNames_Challenge[i];    	
      break;
    case GAME_TYPE_TRADITIONAL:
      HighScoresTempInt[i] = HighScoresValue_Traditional[i];
      HighScoresTempStr[i] = HighScoresNames_Traditional[i];    	
      break;
    default:
      break;
   }
  
  HighScoresTempInt[MAX_HIGH_SCORES - 1] = CurrentPlayerScore;
  HighScoresTempStr[MAX_HIGH_SCORES - 1] = name; 
  
  Highest2Lowest( HighScoresTempStr, HighScoresTempInt );
 
  for( i = 0; i < MAX_HIGH_SCORES; i++ )	 
  switch(CurrentGameType)
  {
   case GAME_TYPE_ORIGINAL: 
	 HighScoresValue_Original[i] = HighScoresTempInt[i]; 
	 HighScoresNames_Original[i] = HighScoresTempStr[i];
     break;
   case GAME_TYPE_CHALLENGE:
     HighScoresValue_Challenge[i] = HighScoresTempInt[i];
     HighScoresNames_Challenge[i] = HighScoresTempStr[i];    	
     break;
   case GAME_TYPE_TRADITIONAL:
     HighScoresValue_Traditional[i] = HighScoresTempInt[i];
     HighScoresNames_Traditional[i] = HighScoresTempStr[i];    	
     break;
   default:
     break;
  }	
 
}
//-------------------------------------------------------------------------------------
static public void EditCurrentPlayerName( int ChangeCursorPosition, int ChangeCharacter )
{
  char[] NameChars = CurrentPlayerName.toCharArray();
		  
  if( ChangeCursorPosition < 0 )
	  CurrentPlayerNameCursorPosition--;
  else
  if( ChangeCursorPosition > 0 )
	  CurrentPlayerNameCursorPosition++;
  
  if( CurrentPlayerNameCursorPosition < 0 )
	  CurrentPlayerNameCursorPosition = 0;
  
  if( CurrentPlayerNameCursorPosition > MAX_HIGH_SCORE_NAME_LENGTH - 1 )
	  CurrentPlayerNameCursorPosition = MAX_HIGH_SCORE_NAME_LENGTH - 1;    

  if( ChangeCharacter < 0 )
	  NameChars[CurrentPlayerNameCursorPosition]--;
  else
  if( ChangeCharacter > 0 )
	  NameChars[CurrentPlayerNameCursorPosition]++;
 
  
  if( NameChars[CurrentPlayerNameCursorPosition] < 45 )
	  NameChars[CurrentPlayerNameCursorPosition] = 95;
  
  if( NameChars[CurrentPlayerNameCursorPosition] > 95 )
	  NameChars[CurrentPlayerNameCursorPosition] = 45;
  
  CurrentPlayerName = new String(NameChars); 
}
//-------------------------------------------------------------------------------------
public static void ChangeBackGround()
{
//BackDrop.SetProperties( SimpleBackGround.STYLE_PICTURE_TILED, Color.rgb(0,100,0), BackGroundIndex + 1, 48, 48 );

  int Digit1 = GameGlobals.BackGroundIndex % 10;
  int Digit0 = GameGlobals.BackGroundIndex / 10;
	
  BackDrop.SetTileStyle( GameControl.IMAGE_TILES_BACKGROUND, Digit1, Digit0, 1, 1, 48, 48, 255 );
}
//-------------------------------------------------------------------------------------
public static void SetPlayData( int LayerIndex, 
	       int BlockShape_Id,
	       int BlockShape_GridX,
	       int BlockShape_GridY,
	       char[][] BlockShape_BlockData,
	       int BlockShape_EnabledFlag,       
	       int BlockShape_Next_Id,
	       char[][] BlockShape_Next_BlockData,
	       int BlockShape_Next_EnabledFlag,       
	       char[][] PlayField_BlockData    
	    )
	    {
	       int x, y;
	       
	       GameSaveData[LayerIndex].BlockShape_Id = BlockShape_Id;
	       GameSaveData[LayerIndex].BlockShape_GridX = BlockShape_GridX;
	       GameSaveData[LayerIndex].BlockShape_GridY = BlockShape_GridY;
	       GameSaveData[LayerIndex].BlockShape_Next_Id = BlockShape_Next_Id;
	       
	       GameSaveData[LayerIndex].BlockShape_EnabledFlag = BlockShape_EnabledFlag;
	       GameSaveData[LayerIndex].BlockShape_Next_EnabledFlag = BlockShape_Next_EnabledFlag;
	       
	       for( y = 0; y < SHAPE_HEIGHT; y++ )
	        for( x = 0; x < SHAPE_WIDTH; x++ )
	        {
	        	GameSaveData[LayerIndex].BlockShape_BlockData[x][y] = BlockShape_BlockData[x][y];
	        	GameSaveData[LayerIndex].BlockShape_Next_BlockData[x][y] = BlockShape_Next_BlockData[x][y];
	        }
	        
	       for( y = 0; y < FIELD_GRID_HEIGHT; y++ )
	        for( x = 0; x < FIELD_GRID_WIDTH; x++ )
	        	GameSaveData[LayerIndex].PlayField_BlockData[x][y] = PlayField_BlockData[x][y];        
	    }    
//-------------------------------------------------------------------------------------
        public static void ClearSaveGameData()
        {
          LoadGameFileFlag = 0;
          GE.FileDataStr = ""; 	
  	      GE.FileName = GameFileName;	        	      
  	      GE.FileOperationFlag = GE.G_REQUEST_WRITE_FILE;
        }
//-------------------------------------------------------------------------------------	
        public static void SaveOptionsData()
        {
	        int i, x, y;
	        
	        GE.FileDataStr = new String();
	        
	        GE.FileDataStr = GameSpeed + "," + PitCount + "," + SoundsFlag + "," + GarbageBlocksFlag + "," + BackGroundIndex + ",";
	        
	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	           GE.FileDataStr += HighScoresNames_Original[i] + "," + HighScoresValue_Original[i] + ",";

	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	           GE.FileDataStr += HighScoresNames_Challenge[i] + "," + HighScoresValue_Challenge[i] + ",";

	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	           GE.FileDataStr += HighScoresNames_Traditional[i] + "," + HighScoresValue_Traditional[i] + ",";    

	        GE.FileDataStr += TileImageIndex_1 + "," + TileImageIndex_2 + "," + MainFontColor + ",";
	        GE.FileDataStr += TileImageIndex_2_CellStartY_1 + "," + TileImageIndex_2_CellStartY_2 + ",";
	        GE.FileDataStr += UseClassicRandomMethodFlag + "," + InterfaceStyleIndex + ",";
	        
		    GE.FileName = OptionsFileName;
		    GE.FileOperationFlag = GE.G_REQUEST_WRITE_FILE;	      	              
        }
//-------------------------------------------------------------------------------------
        public static void LoadOptionsData()
        {
  	      if( GE.FileDataStr.length() < 10 )	      
  	    	return;
  	      
  	      String[] list;
  	      int i, Index = 0;
  	      
  	      list = GE.FileDataStr.split(",");
  	      
  	      if( list.length < 35)
                return;
  	        	      
  	      GameSpeed = Integer.parseInt(list[0]);
  	      PitCount = Integer.parseInt(list[1]);
  	      SoundsFlag = Integer.parseInt(list[2]);
  	      GarbageBlocksFlag = Integer.parseInt(list[3]);
  	      BackGroundIndex = Integer.parseInt(list[4]);
  	      
  	        Index = 5;
  	        
  	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
  	        {
              HighScoresNames_Original[i] = list[Index];
  		      Index++;
  		      HighScoresValue_Original[i] = Integer.parseInt(list[Index]);
  		      Index++;
  	        }
  	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
  	        {	
  		      HighScoresNames_Challenge[i] = list[Index];
  		      Index++;
  		      HighScoresValue_Challenge[i] = Integer.parseInt(list[Index]);
  		      Index++;
  	        }
  	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
  	        {	
  		      HighScoresNames_Traditional[i] = list[Index];
  		      Index++;
  		      HighScoresValue_Traditional[i] = Integer.parseInt(list[Index]);
  		      Index++;
  	        }

  	        if( Index > list.length - 1 )
  	        	return;
  	        
	        TileImageIndex_1 = Integer.parseInt(list[Index]);  Index++;	        
	        TileImageIndex_2 = Integer.parseInt(list[Index]);  Index++;
	        MainFontColor = Integer.parseInt(list[Index]);  Index++;	        
	        TileImageIndex_2_CellStartY_1 = Integer.parseInt(list[Index]);  Index++;
	        TileImageIndex_2_CellStartY_2 = Integer.parseInt(list[Index]);  Index++;
	        
	        UseClassicRandomMethodFlag = Integer.parseInt(list[Index]);  Index++;
	        InterfaceStyleIndex = Integer.parseInt(list[Index]);  Index++;	        
 	        
	        ChangeBackGround();
        }
//-------------------------------------------------------------------------------------	        
	    public static void SaveGameData()
	    {
	        int i, x, y;
	        
	        GE.FileDataStr = new String();
	        
	        GE.FileDataStr = GameSpeed + "," + PitCount + "," + SoundsFlag + "," + GarbageBlocksFlag + "," + BackGroundIndex + ",";
	        
	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	           GE.FileDataStr += HighScoresNames_Original[i] + "," + HighScoresValue_Original[i] + ",";

	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	           GE.FileDataStr += HighScoresNames_Challenge[i] + "," + HighScoresValue_Challenge[i] + ",";

	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	           GE.FileDataStr += HighScoresNames_Traditional[i] + "," + HighScoresValue_Traditional[i] + ",";    

	      GE.FileDataStr += CurrentPlayerScore + "," + CurrentGameType + "," + CurrentLineCount + ",";
	      
	      for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )
	      {
	        GE.FileDataStr +=  GameSaveData[i].BlockShape_Id + ",";
	        GE.FileDataStr +=  GameSaveData[i].BlockShape_GridX + "," + GameSaveData[i].BlockShape_GridY + ",";
	        
	        for( y = 0; y < SHAPE_HEIGHT; y++ )
	          for( x = 0; x < SHAPE_WIDTH; x++ )
	            GE.FileDataStr += (int)GameSaveData[i].BlockShape_BlockData[x][y] + ","; 
	            
	        GE.FileDataStr += GameSaveData[i].BlockShape_EnabledFlag + ",";
	        
	        GE.FileDataStr +=  GameSaveData[i].BlockShape_Next_Id + ",";
	       

	        for( y = 0; y < SHAPE_HEIGHT; y++ )
	          for( x = 0; x < SHAPE_WIDTH; x++ )
	            GE.FileDataStr += (int)GameSaveData[i].BlockShape_Next_BlockData[x][y] + ","; 
	            
	        GE.FileDataStr += GameSaveData[i].BlockShape_Next_EnabledFlag + ","; 

	        for( y = 0; y < FIELD_GRID_HEIGHT; y++ )
	          for( x = 0; x < FIELD_GRID_WIDTH; x++ )   
	             GE.FileDataStr += (int)GameSaveData[i].PlayField_BlockData[x][y] + ",";      
	      }

	        GE.FileDataStr += TileImageIndex_1 + "," + TileImageIndex_2 + "," + MainFontColor + ",";
	        GE.FileDataStr += TileImageIndex_2_CellStartY_1 + "," + TileImageIndex_2_CellStartY_2 + ",";
	        GE.FileDataStr += UseClassicRandomMethodFlag + "," + InterfaceStyleIndex + ",";	     	      
	      GE.FileName = GameFileName;
	      //GE.FileOperationFlag = GE.G_REQUEST_WRITE_FILE;
	    }
//-------------------------------------------------------------------------------------	    
	    public static void LoadGameData()
	    {	    	
	      int i, x, y, Index;
	      
	      if( GE.FileDataStr.length() < 1251 )	      
	      {
	    	LoadGameFileFlag = 0;  
	    	return;
	      }
	      
	      String[] list;
	      
	      list = GE.FileDataStr.split(",");
	      
	      if( list.length < 1251)
	      {
	    	  LoadGameFileFlag = 0;
              return;
	      }
	      
	      LoadGameFileFlag = 1;
	      
	      GameSpeed = Integer.parseInt(list[0]);
	      PitCount = Integer.parseInt(list[1]);
	      SoundsFlag = Integer.parseInt(list[2]);
	      GarbageBlocksFlag = Integer.parseInt(list[3]);
	      BackGroundIndex = Integer.parseInt(list[4]);
	      
	        Index = 5;
	        
	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	        {	
		      HighScoresNames_Original[i] = list[Index];
		      Index++;
		      HighScoresValue_Original[i] = Integer.parseInt(list[Index]);
		      Index++;
	        }
	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	        {	
		      HighScoresNames_Challenge[i] = list[Index];
		      Index++;
		      HighScoresValue_Challenge[i] = Integer.parseInt(list[Index]);
		      Index++;
	        }
	        for( i = 0; i < MAX_HIGH_SCORES; i++ )
	        {	
		      HighScoresNames_Traditional[i] = list[Index];
		      Index++;
		      HighScoresValue_Traditional[i] = Integer.parseInt(list[Index]);
		      Index++;
	        }	        
            
            CurrentPlayerScore = Integer.parseInt(list[Index]);
            Index++;
            CurrentGameType = Integer.parseInt(list[Index]);
            Index++;
            CurrentLineCount = Integer.parseInt(list[Index]);
            Index++;
            
		      for( i = 0; i < MAX_PLAY_FIELD_LAYERS; i++ )
		      {
		        GameSaveData[i].BlockShape_Id = Integer.parseInt(list[Index]);
                Index++;
                GameSaveData[i].BlockShape_GridX = Integer.parseInt(list[Index]); 
                Index++;
                GameSaveData[i].BlockShape_GridY = Integer.parseInt(list[Index]);
                Index++;
                
		        for( y = 0; y < SHAPE_HEIGHT; y++ )
		          for( x = 0; x < SHAPE_WIDTH; x++ )
		          {	  
		            GameSaveData[i].BlockShape_BlockData[x][y] = (char)Integer.parseInt(list[Index]);
		            Index++;
		          }
		        
		        GameSaveData[i].BlockShape_EnabledFlag = Integer.parseInt(list[Index]);
		        Index++;
		        GameSaveData[i].BlockShape_Next_Id = Integer.parseInt(list[Index]);
                Index++;
                
		        for( y = 0; y < SHAPE_HEIGHT; y++ )
		          for( x = 0; x < SHAPE_WIDTH; x++ )
		          {	  
		            GameSaveData[i].BlockShape_Next_BlockData[x][y] = (char)Integer.parseInt(list[Index]); 
		            Index++;
		          }
		        
		        GameSaveData[i].BlockShape_Next_EnabledFlag = Integer.parseInt(list[Index]); 
                Index++;
                
		        for( y = 0; y < FIELD_GRID_HEIGHT; y++ )
		          for( x = 0; x < FIELD_GRID_WIDTH; x++ )   
		          {
		             GameSaveData[i].PlayField_BlockData[x][y] = (char)Integer.parseInt(list[Index]);   
		             Index++;
		          }
		          
		      }	  

		        if( Index > list.length - 1 )
		        	return;
		        
		        TileImageIndex_1 = Integer.parseInt(list[Index]);  Index++;
		        TileImageIndex_2 = Integer.parseInt(list[Index]);  Index++;
		        MainFontColor =  Integer.parseInt(list[Index]);  Index++;	        
		        TileImageIndex_2_CellStartY_1 = Integer.parseInt(list[Index]);  Index++;
		        TileImageIndex_2_CellStartY_2 = Integer.parseInt(list[Index]);  Index++;	        
		        UseClassicRandomMethodFlag = Integer.parseInt(list[Index]);  Index++;
		        InterfaceStyleIndex = Integer.parseInt(list[Index]);  Index++;		        		      
          
	    }
	    //------------------------------------------------------------------------------------- 
	    public static void SetDrawTileSize( int nCellWidthPixels, int nCellHeightPixels )
	    {    	
	      CellWidthPixels = nCellWidthPixels;  	
	      CellHeightPixels = nCellHeightPixels;
	      CellWidthPixelsEnlarged = nCellWidthPixels + 2;  	
	      CellHeightPixelsEnlarged = nCellHeightPixels + 2;      
	    }
	  //-------------------------------------------------------------------------------------     
	    public static void DrawTileImage( int ImageIndex, int X, int Y, int Z, int AlphaValue, int CellX, int CellY )
	    {
	      GE.DrawSubImage( ImageIndex, X, Y, Z, AlphaValue, CellX * (CellWidthPixelsEnlarged + 2) + 1, 
	    		  CellY * (CellHeightPixelsEnlarged + 2) + 1, CellWidthPixels, CellHeightPixels );      

	    }
	//------------------------------------------------------------------------------------- 
	    public static void DrawTileImageGeneral( int ImageIndex, int X, int Y, int Z, int AlphaValue, int CellX, int CellY,
	    		int Width_Cells, int Height_Cells )
	    {	    		
	        GE.DrawSubImage( ImageIndex, X, Y, Z, AlphaValue, CellX * (CellWidthPixelsEnlarged + 2) + 1, 
	      		  CellY * (CellHeightPixelsEnlarged + 2) + 1,
	    		  CellWidthPixels * Width_Cells, 
	    		  CellHeightPixels * Height_Cells );      

	    }
	//-------------------------------------------------------------------------------------
	    public static void DrawTileImageGeneralUltra( int ImageIndex, int X, int Y, int Z, int AlphaValue, int CellX, int CellY,
	    		int Width_Cells, int Height_Cells, int TileWidthPixels, int TileHeightPixels )
	    {
	    	int TileWidthPixelsEnlarged = TileWidthPixels + 2;
	    	int TileHeightPixelsEnlarged = TileHeightPixels + 2; 	
	         
	        GE.DrawSubImage( ImageIndex, X, Y, Z, AlphaValue, CellX * (TileWidthPixelsEnlarged + 2) + 1, 
	      		  CellY * (TileHeightPixelsEnlarged + 2) + 1,
	      		  TileWidthPixels * Width_Cells, 
	      		  TileHeightPixels * Height_Cells );
	    }
	//------------------------------------------------------------------------------------- 
	    public static void InterfaceColors_Update_Variables()
	    {
	      int list_A[] = { 49,51,52,53,54,  55,56,57,58,59 };
	      //int list_A[] = { 49,49,49,49,49,  49,49,49,49,49 };
	      
	      int list_text_color[] = { 
	       Color.rgb(255,255,0), Color.rgb(255,255,0), Color.rgb(255,255,0),
	       Color.rgb(0,0,255), Color.rgb(255,0,0), Color.rgb(0x91,0x2C,0xEE),
	       Color.rgb(128,0,128), Color.rgb(255,255,255), Color.rgb(0,255,0),
	       Color.rgb(230,230,230)
	       };        
	 /* 
	      yellow/blue; yellow/black; yellow/red; 
	      blue/black; red/black; purple/black
	      white/purple; white/blue; green/purple;
	      gray/black;
	 */        
	      
	      TileImageIndex_1 = list_A[InterfaceStyleIndex];
	      MainFontColor = list_text_color[InterfaceStyleIndex];
	    }	    
	//------------------------------------------------------------------------------------- 	
public static String SetMinTextWidthLeft( String str, String pad_char, int min_width )
{
  int i, difference, length = str.length();

  if( length < min_width )
  {
    StringBuilder strb = new StringBuilder();
    difference = min_width - length;

    for( i = 0; i < difference; i++ )
        strb.append(pad_char);
    
    strb.append(str);
    return strb.toString();
  }
  else
    return str;
}
//-------------------------------------------------------------------------------------	
public static void DrawTileImageOne( int ImageIndex, int X, int Y, int Z, int AlphaValue, int CellX, int CellY,
	    	int nCellWidthPixels, int nCellHeightPixels)
{
	      GE.DrawSubImage( ImageIndex, X, Y, Z, AlphaValue, CellX * (nCellWidthPixels + 1) + 1, 
	    		  CellY * (nCellHeightPixels + 1) + 1, nCellWidthPixels-1, nCellHeightPixels-1 );      
/*
 0123456789
0##########
1#  #  #  #
2#  #  #  #
3##########  
4#  #  #  #
5#  #  #  #
6########## 
7#  #  #  #
8#  #  #  #
9##########
 
(w + 1) * x + 1 
(h + 1) * y + 1
*/
}	    
//-------------------------------------------------------------------------------------
public static void CalculateFontSize()
{
   HeaderFontSize1 = 25 * GameEngine.ScreenWidth/480;
   HeaderFontSize2 = 30 * GameEngine.ScreenWidth/480;
   RegularFontSize1 = 20 * GameEngine.ScreenWidth/480;
}
//-------------------------------------------------------------------------------------
public static int random( int lower, int upper )
{
   return rand.nextInt(upper - lower + 1) + lower;
}
//------------------------------------------------------------------------------------- 
static int PowerRandom10( int lowerbound, int upperbound )
{
  float rnd = (float)Math.pow( 10, 2 * Math.random() )/100;

  return (int)(Math.floor((upperbound - lowerbound + 1) * rnd )) + lowerbound;
}
//-------------------------------------------------------------------------------------
static int PowerRandom( int lowerbound, int upperbound, float base, float exponent )
{
  float rnd = (float)(Math.pow( base, exponent * Math.random() )/Math.pow( base, exponent ));

  return (int)(Math.floor((upperbound - lowerbound + 1) * rnd )) + lowerbound;
}
//-------------------------------------------------------------------------------------
public static int CheckVersionCode()
{
   int version_code = ParalleliaActivity.CurrentObj.GetVersionCode();
   int saved_version_code = 0, return_value = -1;
   
   GameEngine ge = GameEngine.CurrentObj;
   
   ge.FileName = "version.txt";
   ge.DoRequest(ge.G_REQUEST_READ_FILE);	
   String str = ge.FileDataStr;
   
   ge.FileName = "version.txt";
   ge.FileDataStr = version_code + ", ";
   ge.DoRequest(ge.G_REQUEST_WRITE_FILE);	   
  
   if( str.length() < 1 )
	   return return_value;
   
   String[] list = str.split(",");
   saved_version_code = Integer.parseInt(list[0]);
   
   if( list.length < 1 )
	    return return_value;
   
   if( saved_version_code > version_code )
	   return_value = -1;
   else
   if( saved_version_code == version_code )
	   return_value = 0;  
   else
   if( saved_version_code < version_code )
	   return_value = 1; 

   return return_value;
}
//------------------------------------------------------------------------------------
public static void ClearFilesDifferentVersion()
{
  GameEngine ge = GameEngine.CurrentObj;
    
  if( CheckVersionCode() != 0 )
  {
    ge.FileDataStr = "";
    ge.FileName = "gamesave.txt";
    ge.DoRequest(ge.G_REQUEST_WRITE_FILE);
    ge.FileDataStr = "";
    ge.FileName = "options.txt";
    ge.DoRequest(ge.G_REQUEST_WRITE_FILE);
  }
}	
//-------------------------------------------------------------------------------------
public static String repeat(String str, int times)
{
   StringBuilder ret = new StringBuilder();
   for(int i = 0;i < times;i++) 
	   ret.append(str);
   return ret.toString();
}
//-------------------------------------------------------------------------------------
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
abstract class GameObject
{
public float X, Y;
public int GridX, GridY;
public String Name;

public static int MouseX, MouseY, MouseStatus;
public static int KeyCode, KeyStatus;

public boolean MouseEventNotifyFlag, KeyEventNotifyFlag;

public static final int ME_NOTHING = -1;
public static final int ME_PRESS_DOWN = 0;
public static final int ME_RELEASE = 1; 
public static final int ME_MOVE = 2;  

public static final int ME_KEY_DOWN = 3;
public static final int ME_KEY_UP = 4;

public int MouseX_Dup, MouseY_Dup, MouseStatus_Dup;
public int KeyCode_Dup, KeyStatus_Dup;

public static final int ScreenWidth = 320;
public static final int ScreenHeight = 480;

protected static GameEngine GE;

protected int TextLayer;
protected int PictureLayer;

public int UniqueId;
public int GroupId;

public char[] ClassType;
public static final int MAX_CLASS_TYPES = 100;

/* input delay */

public int InputDelayMax;
public int InputDelayCounter;

/* Add extended class types here */
  
public static final char TYPE_BUTTON = 0;
public static final char TYPE_CAPTION = 1;
public static final char TYPE_CHECKBOX = 2;
public static final char TYPE_RADIO_BUTTON = 3;
public static final char TYPE_MULTI_STATE_BUTTON = 4;
public static final char TYPE_SIMPLE_BACKGROUND = 5;
public static final char TYPE_BLOCK_GAME_ENGINE = 6;
public static final char TYPE_MENU_CURSOR_PARALLELIA = 7;
public static final char TYPE_CAPTION_BOX = 8;
public static final char TYPE_CELL_SAMPLE_DISPLAY = 9;
public static final char TYPE_COPYRIGHT_CAPTION = 50;

//-------------------------------------------------------------------------------------
public GameObject()
{
  X = Y = 0.0f; GridX = GridY = 0;
  Name = new String("");
  ClassType = new char[MAX_CLASS_TYPES];
  MouseEventNotifyFlag = KeyEventNotifyFlag = false;
  UniqueId = 0; GroupId = 0;
  PictureLayer = GE.LAYER_0; 
  TextLayer = GE.LAYER_1;
  ClearDupInput();
  
  InputDelayMax = 5;
  InputDelayCounter = 0;
}
//-------------------------------------------------------------------------------------
public static void SetGameEngine( GameEngine pGE )
{
  GE = pGE;
}
//-------------------------------------------------------------------------------------
public void SetLayers( int nTextLayer, int nPictureLayer )
{
  TextLayer = nTextLayer; PictureLayer = nPictureLayer;
}
//-------------------------------------------------------------------------------------
public void Draw() {}
public void Do() {}
public void OnClick() {}
public void OnKey() {}
//-------------------------------------------------------------------------------------
public void CopyDupInput()
{
  MouseX_Dup = MouseX;
  MouseY_Dup = MouseY;
  MouseStatus_Dup = MouseStatus;
  KeyCode_Dup = KeyCode;
  KeyStatus_Dup = ME_NOTHING;	
}
//-------------------------------------------------------------------------------------
public void ClearDupInput()
{
 MouseX_Dup = MouseY_Dup = MouseStatus_Dup =
   KeyCode_Dup = KeyStatus_Dup = ME_NOTHING;
}
//-------------------------------------------------------------------------------------
}

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class Button extends GameObject
{

public static final int BUTTON_RELEASED = 0;
public static final int BUTTON_PRESSED = 1;

public static final int STYLE_PRIMITIVE = 1;
public static final int STYLE_PICTURE = 2;

public static final int BUTTON_MECHANIC_NORMAL = 0;
public static final int BUTTON_MECHANIC_STICKY = 1;

protected int ButtonState;
protected int Width, Height;
protected int BorderColor0, InnerColor0, DrawStyle0, PictureIndex0, TextColor0;
protected int BorderColor1, InnerColor1, DrawStyle1, PictureIndex1, TextColor1;
protected int FontSize;
protected int ButtonMechanic;

protected int PictureIndex0_TileX, PictureIndex0_TileY;
protected int PictureIndex1_TileX, PictureIndex1_TileY;
protected int PictureWidthCells, PictureHeightCells;
protected int TileWidthPixels, TileHeightPixels;
protected int AlphaValue;

protected int DrawAltFlag = 0;

//-------------------------------------------------------------------------------------
public Button()
{
super();
ClassType[TYPE_BUTTON] = 1;
ButtonState = BUTTON_RELEASED;
MouseEventNotifyFlag = true;
PictureLayer = GE.LAYER_1;
TextLayer = GE.LAYER_2;
AlphaValue = 255;
}
//-------------------------------------------------------------------------------------
public Button( String Caption, int nX, int nY, int nWidth, int nHeight )
{
super();
ClassType[TYPE_BUTTON] = 1;
Name = new String(Caption);
X = nX; Y = nY; Width = nWidth; Height = nHeight;
ButtonState = BUTTON_RELEASED;
MouseEventNotifyFlag = true;

DrawStyle0 = STYLE_PRIMITIVE;
InnerColor0 = Color.rgb(100,100,100);
BorderColor0 = Color.rgb(255, 0, 0);
TextColor0 = Color.rgb(255, 0, 0);
PictureIndex0 = 0;

DrawStyle1 = STYLE_PRIMITIVE;
InnerColor1 = Color.rgb(100,100,100);
BorderColor1 = Color.rgb(255, 255, 255);
TextColor1 = Color.rgb(255, 255, 255);
PictureIndex1 = 0;

FontSize = 18;
ButtonMechanic = BUTTON_MECHANIC_NORMAL;
PictureLayer = GE.LAYER_1;
TextLayer = GE.LAYER_2;

PictureIndex0_TileX = PictureIndex0_TileY = -1;
PictureIndex1_TileX = PictureIndex1_TileY = -1;
PictureWidthCells = PictureHeightCells = -1;
AlphaValue = 255;
}
//-------------------------------------------------------------------------------------
public void SetReleasedStyle( int nDrawStyle, int nBorderColor, int nInnerColor, int nPictureIndex, 
         int nTextColor )
{
DrawStyle0 = nDrawStyle; BorderColor0 = nBorderColor; InnerColor0 = nInnerColor; 
PictureIndex0 = nPictureIndex; TextColor0 = nTextColor;
}
//------------------------------------------------------------------------------------- 
public void SetPressedStyle( int nDrawStyle, int nBorderColor, int nInnerColor, int nPictureIndex, 
         int nTextColor )
{
DrawStyle1 = nDrawStyle; BorderColor1 = nBorderColor; InnerColor1 = nInnerColor; 
PictureIndex1 = nPictureIndex; TextColor1 = nTextColor;
}
//------------------------------------------------------------------------------------- 
protected boolean CheckClickWithin()
{
boolean returnvalue = false;

if( X <= MouseX && MouseX < X + Width &&
    Y <= MouseY && MouseY < Y + Height )
    returnvalue = true;
return returnvalue;    
}
//-------------------------------------------------------------------------------------
protected void DrawPressed()
{
if( DrawStyle1 == STYLE_PRIMITIVE )
{
  GE.DrawBox( X, Y, X+Width, Y+Height, PictureLayer, BorderColor1, 
    GameEngine.G_STYLE_FILL );
  GE.DrawBox( X+2, Y+2, X+Width-2, Y+Height-2, PictureLayer, InnerColor1, 
    GameEngine.G_STYLE_FILL );
  GE.DrawTextColor( Name,(int)X+5, (int)Y+Height-10, TextLayer, TextColor1, FontSize );
}
else
if( DrawStyle1 == STYLE_PICTURE )
{
  if( PictureIndex1_TileX > -1 )
      GameGlobals.DrawTileImageGeneralUltra( PictureIndex1, (int)X, (int)Y, PictureLayer, AlphaValue, PictureIndex1_TileX, PictureIndex1_TileY, 
    	PictureWidthCells, PictureHeightCells, TileWidthPixels, TileHeightPixels );  
  else	
      GE.DrawImage( PictureIndex1, (int)X, (int)Y, PictureLayer );    
}
}
//-------------------------------------------------------------------------------------
protected void DrawReleased()
{
if( DrawStyle0 == STYLE_PRIMITIVE )
{
  GE.DrawBox( X, Y, X+Width, Y+Height, PictureLayer, BorderColor0, 
    GameEngine.G_STYLE_FILL );
  GE.DrawBox( X+2, Y+2, X+Width-2, Y+Height-2, PictureLayer, InnerColor0, 
    GameEngine.G_STYLE_FILL );
  GE.DrawTextColor( Name,(int)X+5, (int)Y+Height-10, TextLayer, TextColor0, FontSize );
}
else
if( DrawStyle0 == STYLE_PICTURE )
{
  if( PictureIndex0_TileX > -1 )
	  GameGlobals.DrawTileImageGeneralUltra( PictureIndex0, (int)X, (int)Y, PictureLayer, AlphaValue, PictureIndex0_TileX, PictureIndex0_TileY, 
	    PictureWidthCells, PictureHeightCells, TileWidthPixels, TileHeightPixels );  
  else
     GE.DrawImage( PictureIndex0, (int)X, (int)Y, PictureLayer );    
}
}
//-------------------------------------------------------------------------------------
public void Draw()
{  
	
if( DrawAltFlag == 1 )
{
if( ButtonState == BUTTON_RELEASED )
   DrawAlt(0); //DrawReleased();
else
if( ButtonState == BUTTON_PRESSED )
   DrawAlt(1); //DrawPressed();   
}
else
{
if( ButtonState == BUTTON_RELEASED )
   DrawReleased();
else
if( ButtonState == BUTTON_PRESSED )
   DrawPressed();   
}

}
//-------------------------------------------------------------------------------------
public void OnClick() 
{
	int YesFlag = 0;
	
	if( (MouseStatus == ME_PRESS_DOWN || MouseStatus == ME_MOVE ))
	{
     if(  CheckClickWithin() )
	 {
		if( InputDelayMax > 0 )
		{
		  if( InputDelayCounter >= InputDelayMax )
		  {
		    YesFlag = 1;
		    InputDelayCounter = 0;	
		  }
	  
		}	
		else
		  YesFlag = 1;
		
		if( YesFlag == 1 )
		{
		    ButtonState = BUTTON_PRESSED;
		    CopyDupInput();
		    OnClickDo();    
		}
	 }
     else
     {
    	ButtonState = BUTTON_RELEASED;
     }
     
	}
	else 
    if( MouseStatus == ME_RELEASE && ButtonMechanic != BUTTON_MECHANIC_STICKY )
    {  
       ButtonState = BUTTON_RELEASED;
       if( CheckClickWithin() )
           CopyDupInput();
       OnUnClickDo();    
    }
}
//-------------------------------------------------------------------------------------
protected void OnClickDo()
{
}
//-------------------------------------------------------------------------------------
protected void OnUnClickDo()
{
}
//-------------------------------------------------------------------------------------
public void SetMechanic( int Option )
{
  switch( Option )
  { 
    case BUTTON_MECHANIC_NORMAL:
    case BUTTON_MECHANIC_STICKY:
      ButtonMechanic = Option;
    default:
      break;
  }
}
//-------------------------------------------------------------------------------------
public void Do()
{
  if( InputDelayCounter < InputDelayMax )
      InputDelayCounter++;	
}
//-------------------------------------------------------------------------------------
public void SetTileStyle( int nPictureIndex0, int nPictureIndex1, int nPictureIndex0_TileX,
		 int nPictureIndex0_TileY,  int nPictureIndex1_TileX,  int nPictureIndex1_TileY,
		 int nPictureWidthCells, int nPictureHeightCells, int nTileWidthPixels,
		 int nTileHeightPixels, int nAlphaValue )
{
  DrawStyle0 = DrawStyle1 = STYLE_PICTURE;	 
  PictureIndex0 = nPictureIndex0;
  PictureIndex1 = nPictureIndex1;
  PictureIndex0_TileX = nPictureIndex0_TileX;
  PictureIndex0_TileY = nPictureIndex0_TileY;
  PictureIndex1_TileX = nPictureIndex1_TileX;
  PictureIndex1_TileY = nPictureIndex1_TileY;
  PictureWidthCells = nPictureWidthCells;
  PictureHeightCells = nPictureHeightCells;
  TileWidthPixels = nTileWidthPixels;
  TileHeightPixels = nTileHeightPixels;
  AlphaValue = nAlphaValue;
}
//-------------------------------------------------------------------------------------
public void Create_WidthxHeight( int nX, int nY, int nWidth, int nHeight, int nGroupId, int nUniqueId, int nPictureLayer, int nTextLayer, 
   int nPictureIndex, int nRowIndex0, int nRowIndex1, int nAlpha )
{
 Width = nWidth; Height = nHeight;

 X = nX; Y = nY; GroupId = nGroupId; UniqueId = nUniqueId;
 PictureLayer = nPictureLayer; TextLayer = nTextLayer;

int ScaledWidth = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * Width);
int ScaledHeight = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * Height);

SetTileStyle( nPictureIndex, nPictureIndex, 0, nRowIndex0, 0, nRowIndex1, 1, 1, ScaledWidth, ScaledHeight, nAlpha  );

DrawAltFlag = 1;
}
//--------------------------------------------------------------------------
public void Set_TileX( int nPictureIndex0_TileX, int nPictureIndex1_TileX )
{
PictureIndex0_TileX = nPictureIndex0_TileX; PictureIndex1_TileX = nPictureIndex1_TileX;
}
//--------------------------------------------------------------------------
public void DrawAlt( int nState )
{
  if( nState == 0 )
     GameGlobals.DrawTileImageOne( PictureIndex0, (int)X, (int)Y, PictureLayer, AlphaValue, PictureIndex0_TileX, PictureIndex0_TileY, 
    	 TileWidthPixels, TileHeightPixels );
  else
  if( nState == 1 )
     GameGlobals.DrawTileImageOne( PictureIndex1, (int)X, (int)Y, PictureLayer, AlphaValue, PictureIndex1_TileX, PictureIndex1_TileY, 
    	 TileWidthPixels, TileHeightPixels );
}
//--------------------------------------------------------------------------
public int GetButtonState()
{
   return ButtonState;
}
//--------------------------------------------------------------------------
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class Caption extends GameObject
{
  public static final int STYLE_TEXT = 0;
  public static final int STYLE_PICTURE = 1;
  public static final int STYLE_TEXT_PICTURE = 2;

  protected int Style;  
  protected int PictureIndex;
  protected int FontSize;
  protected int FontColor;
  protected String Text;
  protected int TextRelativeX;
  protected int TextRelativeY;    
  protected int DistanceBetweenLines;
  protected boolean MultiLineFlag;
  protected boolean DrawCursorFlag;
  protected int CursorCharPosition;
  
  protected int PictureIndex_TileX, PictureIndex_TileY;
  protected int PictureWidthCells, PictureHeightCells;
  protected int TileWidthPixels, TileHeightPixels;
  protected int AlphaValue = 255;  
  
  protected int TileImageFlag = 0;
  
  public static int TextShadowFlag = 1;
  public static int TextShadowColor = Color.rgb(20,20,20);
  public static int TextShadowDisplaceX = -1;
  public static int TextShadowDisplaceY = -1;
  public static int TextShadowCount = 2;
  
//-------------------------------------------------------------------------------------
 public Caption()
 {
  super();
  ClassType[TYPE_CAPTION] = 1;	
  PictureIndex_TileX = PictureIndex_TileY = -1;
 }
 //-------------------------------------------------------------------------------------
public Caption( int nX, int nY, int nPictureIndex )
{
 super();
 ClassType[TYPE_CAPTION] = 1;
 FontSize = 20;
 FontColor = Color.rgb(255,255,255);
 TextRelativeX = 0; TextRelativeY = 20;
	  
  Style = STYLE_PICTURE;
  X = nX; Y = nY; PictureIndex = nPictureIndex;
  MultiLineFlag = false;
  DistanceBetweenLines = 20;
  PictureLayer = GE.LAYER_1;
  TextLayer = GE.LAYER_2;  
  DrawCursorFlag = false;
  
  PictureIndex_TileX = PictureIndex_TileY = -1;
}
//-------------------------------------------------------------------------------------
public Caption( int nX, int nY, String sText )
{
  super();
  ClassType[TYPE_CAPTION] = 1;
  FontSize = 20;
  FontColor = Color.rgb(255,255,255);
  TextRelativeX = 0; TextRelativeY = 20;
	 
  Style = STYLE_TEXT;
  X = nX; Y = nY; Text = new String(sText);
  MultiLineFlag = false;
  DistanceBetweenLines = 20;
  PictureLayer = GE.LAYER_1;
  TextLayer = GE.LAYER_2;    
  DrawCursorFlag = false;
  
  PictureIndex_TileX = PictureIndex_TileY = -1;
}
//-------------------------------------------------------------------------------------
public void SetTextOptions( int nFontSize, int nColor, int nTextRelativeX, int nTextRelativeY, boolean bMultiLineFlag,
   int nDistanceBetweenLines )
{
   FontSize = nFontSize;
   FontColor = nColor;
   TextRelativeX = nTextRelativeX;
   TextRelativeY = nTextRelativeY;
   MultiLineFlag = bMultiLineFlag;
   DistanceBetweenLines = nDistanceBetweenLines;
}
//-------------------------------------------------------------------------------------
public void SetText( String sText )
{
  Text = new String(sText);
}
//-------------------------------------------------------------------------------------
public void SetTextPicture( String sText, int nPictureIndex )
{
  Text = new String(sText);
  PictureIndex = nPictureIndex;
  Style = STYLE_TEXT_PICTURE;
}
//-------------------------------------------------------------------------------------
public void Draw() 
{
 int i, k;
 
 if( Style == STYLE_TEXT || Style == STYLE_TEXT_PICTURE )
 {
  if( !MultiLineFlag )
  {
	
   if( TextShadowFlag >= 1 )
   {
    for( i = 1; i <= TextShadowCount; i++ )   
       GE.DrawTextColor( Text,(int)(X + TextRelativeX + TextShadowDisplaceX * i), (int)(Y + TextRelativeY + TextShadowDisplaceY * i), 
         TextLayer, TextShadowColor, FontSize );
   }
   
   GE.DrawTextColor( Text,(int)(X + TextRelativeX), (int)(Y + TextRelativeY), 
       TextLayer, FontColor, FontSize );
   
   if( DrawCursorFlag )
   {
	  int length = Text.length();
	  char[] chlist = new char[length];	  

	  for( i = 0; i < length; i++ )
		   chlist[i] = ' ';
	  chlist[CursorCharPosition] = '_';
	  String cursorstr = new String(chlist);
	  
	   if( TextShadowFlag >= 1 )
	   {
	    for( i = 1; i <= TextShadowCount; i++ )   
         GE.DrawTextColor( cursorstr,(int)(X + TextRelativeX + TextShadowDisplaceX * i), (int)(Y + TextRelativeY + TextShadowDisplaceY * i), 
         TextLayer, TextShadowColor, FontSize );
	   }
	   
	   GE.DrawTextColor( cursorstr,(int)(X + TextRelativeX), (int)(Y + TextRelativeY), 
		       TextLayer, FontColor, FontSize );	  
   }
  }
  else
  {
   int LineY;
   String[] StrLines = Text.split("\n");
   
   for( i = 0, LineY = 0; i < StrLines.length; i++, LineY += DistanceBetweenLines )
   {
     if( TextShadowFlag >= 1 )
     {
      for( k = 1; k <= TextShadowCount; k++ )   
         GE.DrawTextColor( StrLines[i],(int)(X + TextRelativeX + TextShadowDisplaceX * k), 
           (int)(Y + TextRelativeY + LineY + TextShadowDisplaceY * k), TextLayer, TextShadowColor, FontSize );
     }
	 
     GE.DrawTextColor( StrLines[i],(int)(X + TextRelativeX), (int)(Y + TextRelativeY + LineY), 
       TextLayer, FontColor, FontSize );      
   }
  }
 }

 if( TileImageFlag == 1 )
     GameGlobals.DrawTileImageOne( PictureIndex, (int)X, (int)Y, PictureLayer, AlphaValue, 0, PictureIndex_TileY, 
    	 TileWidthPixels, TileHeightPixels ); 
 else
 if( Style == STYLE_PICTURE || Style == STYLE_TEXT_PICTURE )
   GE.DrawImage( PictureIndex, (int)X, (int)Y, PictureLayer );    
}
//-------------------------------------------------------------------------------------
public void SetTileStyle( int nPictureIndex, 
		  int nPictureIndex_TileX, int nPictureIndex_TileY,
		  int nPictureWidthCells, int nPictureHeightCells,
		  int nTileWidthPixels, int nTileHeightPixels,
		  int nAlphaValue )
{
	  PictureIndex = nPictureIndex;
	  PictureIndex_TileX = nPictureIndex_TileX;
	  PictureIndex_TileY = nPictureIndex_TileY;
	  PictureWidthCells = nPictureWidthCells;
	  PictureHeightCells = nPictureHeightCells;
	  TileWidthPixels = nTileWidthPixels;
	  TileHeightPixels = nTileHeightPixels;
	  AlphaValue = nAlphaValue;  	  	  
}
//-------------------------------------------------------------------------------------
public void SetFontColor( int nColor)
{
	FontColor = nColor;	
}
//-------------------------------------------------------------------------------------
public Caption( int nX, int nY, int nGroupId, int nUniqueId, int nStyle, int nTextLayer, int nPictureLayer )
{	
  super();
  ClassType[TYPE_CAPTION] = 1;
  
  X = nX; Y = nY;
  GroupId = nGroupId; UniqueId = nUniqueId;
  Style = nStyle; 
  
  if( nTextLayer < 0 || nPictureLayer < 0 )
  {
	  TextLayer = GE.LAYER_2; PictureLayer = GE.LAYER_1;	 
  }
  else
  {
    TextLayer = nTextLayer; PictureLayer = nPictureLayer;
  }
}
//-------------------------------------------------------------------------------------
public void Init_1( String str, int nFontSize, int nColor, int nTextRelativeX, int nTextRelativeY, boolean bMultiLineFlag,
   int nDistanceBetweenLines )
{
	Text = new String(str);
	
   FontSize = nFontSize;
   FontColor = nColor;
   TextRelativeX = nTextRelativeX;
   TextRelativeY = nTextRelativeY;
   MultiLineFlag = bMultiLineFlag;
   DistanceBetweenLines = nDistanceBetweenLines;	
}
//-------------------------------------------------------------------------------------
public void Init_2( int nPictureIndex, int nWidth, int nHeight, int nRowIndex0, int nAlphaValue, int nTileImageFlag )
{
  int ScaledWidth = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * nWidth);
  int ScaledHeight = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * nHeight);  

  SetTileStyle( nPictureIndex, 0, nRowIndex0,  1, 1, ScaledWidth, ScaledHeight, nAlphaValue );
  TileImageFlag = nTileImageFlag;
}
//-------------------------------------------------------------------------------------
public void GetTextWidthHeightPixels( int[] wh )
{
Paint paintobj = new Paint();	
paintobj.setTextSize(FontSize);
	
Rect bounds = new Rect();
paintobj.getTextBounds(Text, 0, Text.length(), bounds);

wh[0] = bounds.width() / Text.length();	
wh[1] = bounds.height();

}
//-------------------------------------------------------------------------------------
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class CopyRightCaption extends GameObject
{
protected int FontColor, FontShadowColor, FontSize, FontWidth, FontHeight;
protected String Text;

//-------------------------------------------------------------------------------------
public CopyRightCaption()
{
  FontColor = GameGlobals.MainFontColor;
  FontShadowColor = Color.rgb( 20, 20, 20 );
  FontSize = 12;

  Text = "© 2014 Y.X.Y. All Rights Reserved.";
  String teststr = "X                                                    X";

  Paint paintobj = new Paint();
  paintobj.setTypeface(Typeface.MONOSPACE);
  paintobj.setTextSize(FontSize);

  Rect bounds = new Rect();  
  paintobj.getTextBounds(teststr, 0, teststr.length(), bounds);
  
  FontHeight = bounds.height();
  FontWidth = bounds.width() / teststr.length();

  PictureLayer = GE.LAYER_2;
  TextLayer = GE.LAYER_4;
  ClassType[TYPE_COPYRIGHT_CAPTION] = 1;

  paintobj.getTextBounds(Text, 0, Text.length(), bounds);
  
  X = GameEngine.TARGET_SCREEN_WIDTH/2 - (bounds.width()/2)/(GE.Xscale);
  Y = GameEngine.TARGET_SCREEN_HEIGHT - 5;
}
//-------------------------------------------------------------------------------------
public void Draw()
{
   GE.DrawTextColor( Text, (int)X - 1, (int)Y - 1, TextLayer, FontShadowColor, FontSize );	
   GE.DrawTextColor( Text, (int)X, (int)Y, TextLayer, FontColor, FontSize );	
}
//-------------------------------------------------------------------------------------
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class CaptionBox extends GameObject
{
protected int FontColor, FontSize, FontWidth, FontHeight, BoxColor;
public final static int MAX_LINES = 20000;
public final static int VERTICAL_FONT_SPACING = 3;

protected int LineIndex, TotalLines;
protected int BoxWidthPixels, BoxHeightPixels, MaxColumns, MaxRows;
protected String[] TextList;
protected int TopLeftX, TopLeftY;

protected String[] VisibleTextList;
protected char[] TextCharArray;

//-------------------------------------------------------------------------------------
public CaptionBox( int nFontSize, int nFontColor, int nTopLeftX, int nTopLeftY,
                   int nBoxWidthPixels, int nBoxHeightPixels, int nBoxColor )
{
super();

String teststr = "X                                                    X";

FontSize = nFontSize; FontColor = nFontColor; BoxColor = nBoxColor;
TopLeftX = nTopLeftX; TopLeftY = nTopLeftY;
BoxWidthPixels = nBoxWidthPixels; BoxHeightPixels = nBoxHeightPixels;

Paint paintobj = new Paint();
paintobj.setTypeface(Typeface.MONOSPACE);
paintobj.setTextSize(FontSize);

Rect bounds = new Rect();
paintobj.getTextBounds(teststr, 0, teststr.length(), bounds);

FontHeight = bounds.height() + VERTICAL_FONT_SPACING;
FontWidth = bounds.width() / teststr.length();

MaxColumns = (int)(BoxWidthPixels / FontWidth * GE.Xscale);
MaxRows = BoxHeightPixels / FontHeight;
LineIndex = 0;
VisibleTextList = new String[MaxRows];

PictureLayer = GE.LAYER_2;
TextLayer = GE.LAYER_4;
ClassType[TYPE_CAPTION_BOX] = 1;

}
//-------------------------------------------------------------------------------------
public void SetText( String str )
{
if( str.length() < 1 )
    str = " ";
str = str.replace("\r\n", "\n");

int strlength = str.length();
int i, k, ColumnCellCount, WhiteSpaceCount;
char ch; 
StringBuilder sb = new StringBuilder();

char[] char_array = new char[strlength+1];
char[] char_array_nl = new char[strlength+1];

str.getChars (0, strlength-1, char_array, 0);
strlength = char_array.length;

ColumnCellCount = WhiteSpaceCount = 0;

for( i = 0; i < strlength; )
{	
   ch = char_array[i];
     
   if( ch == '\n' )
     ColumnCellCount = 0;
   else        
     ColumnCellCount++;
     
   if( ch == 0x20 || ch == 0x09 || ch == '\n' )  
	   WhiteSpaceCount++;
       
   if( ColumnCellCount >= MaxColumns )
   {     
    if( ch != 0x20 && ch != 0x09 && ch != '\n' )
    {     
      if( WhiteSpaceCount >= 1 )
      {
	    for( k = i - 1; k > 0; k-- )
	    {
		 ch = char_array[k];
		 if( ch == 0x20 || ch == 0x09 || ch == '\n' )
			 break;
	     }
         char_array[k] = '\n';
         i = k;
      }
      else
      {
         char_array_nl[i] = '\n';
      }
      
      WhiteSpaceCount = ColumnCellCount = 0;
    }
    else
      char_array[i] = '\n';
   
   }
   i++;
}

  for( i = 0; i < strlength; i++ )
  {
     sb.append(char_array[i]);
     if( char_array_nl[i] == '\n' )
         sb.append('\n');
  }
//TextList = str.split("\n");
//TotalLines = TextList.length;
//LineIndex = 0;

  str = sb.toString();
  TextCharArray = new char[str.length()];
  str.getChars (0, str.length()-1, TextCharArray, 0);

  TotalLines = 0;
  for( i = 0; i < TextCharArray.length; i++ )
	if( TextCharArray[i] == '\n' )
		TotalLines++;
	else
	if( i == strlength - 1 )
		TotalLines++;   

  SetLineIndex(0);

}
//-------------------------------------------------------------------------------------
public void SetLineIndex( int nLineIndex )
{
	if( nLineIndex >= 0 && nLineIndex < TotalLines )
	  LineIndex = nLineIndex;
	
   StringBuilder sb = new StringBuilder();
   int i, j, k, countlineindex = 0, visiblelineindex = 0;
 
   j = 0;
   
   for( i = 0; i < TextCharArray.length; i++ )
   { 
	 if( LineIndex == countlineindex )
	 {
	    for( k = i; k < TextCharArray.length; k++ )
	    {
	      sb.append(TextCharArray[k]);
	      if( TextCharArray[k] == '\n' )
		      visiblelineindex++;	  
	      if( visiblelineindex >= MaxRows - 1 )
	    	  break;
	    }	
	    break;
	 }

	 if( TextCharArray[i] == '\n' )
		 countlineindex++;
   } 
   VisibleTextList = sb.toString().split("\n");
  
}
//-------------------------------------------------------------------------------------
public void MoveIndex( int nDirection )
{
	int nLineIndex = LineIndex + nDirection;
	
	if( nLineIndex >= 0 && nLineIndex < TotalLines )
	  LineIndex = nLineIndex;   	
	SetLineIndex(LineIndex);
}
//-------------------------------------------------------------------------------------
public void Draw()
{
   int i, k, end_index;
   
   GE.DrawBox( TopLeftX, TopLeftY, TopLeftX + BoxWidthPixels + FontWidth, TopLeftY + BoxHeightPixels + FontHeight, 
		   PictureLayer, BoxColor, GameEngine.G_STYLE_FILL );
/*  
   end_index = LineIndex + MaxRows - 1;
   if( end_index > TotalLines - 1 )
	   end_index = TotalLines - 1;
   
   for( i = LineIndex, k = 0; i <= end_index; i++, k++ )	   
   {	   
	  GE.DrawTextColor( TextList[i], TopLeftX + FontWidth, TopLeftY + k * FontHeight + FontHeight, 
		    TextLayer, FontColor, FontSize );		  
   }
*/  
   for( i = 0; i < VisibleTextList.length; i++  )	   
   {	   
	  GE.DrawTextColor( VisibleTextList[i], TopLeftX + FontWidth, TopLeftY + i * FontHeight + FontHeight, 
		    TextLayer, FontColor, FontSize );		  
   }   
}	   
//-------------------------------------------------------------------------------------	   
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class CheckBox extends GameObject
{
  protected final int STYLE_PRIMITIVE = 0;
  protected final int STYLE_PICTURE = 1;

  protected int OuterColor;
  protected int InnerColor;
  protected int Style;
  protected int Width, Height;  
  protected int CheckedPictureIndex;
  protected int UnCheckedPictureIndex;

  public boolean CheckedFlag = false;
  
  protected int CheckedPictureIndex_TileX, CheckedPictureIndex_TileY;
  protected int UnCheckedPictureIndex_TileX, UnCheckedPictureIndex_TileY;
  protected int PictureWidthCells, PictureHeightCells;
  protected int TileWidthPixels, TileHeightPixels;
  protected int AlphaValue;    
  
  protected int DrawAltFlag = 0;
  
//------------------------------------------------------------------------------------- 
public CheckBox( int nX, int nY, boolean bCheckedFlag )
{
  super();  
  ClassType[TYPE_CHECKBOX] = 1;
  MouseEventNotifyFlag = true;
  CheckedFlag = bCheckedFlag;
  X = nX; Y = nY;
  Width = Height = 48;
  SetPrimitiveStyle( Color.rgb(255,0,0), Color.rgb(100,100,100));
  PictureLayer = GE.LAYER_1;
  CheckedPictureIndex_TileX = -1;
}
//-------------------------------------------------------------------------------------
public void SetPrimitiveStyle( int nOuterColor, int nInnerColor )
{
  Style = STYLE_PRIMITIVE;
  OuterColor = nOuterColor;
  InnerColor = nInnerColor;
}
//-------------------------------------------------------------------------------------
public void SetPictureStyle( int nCheckedPictureIndex, int nUnCheckedPictureIndex )
{
  Style = STYLE_PICTURE;
  CheckedPictureIndex = nCheckedPictureIndex;
  UnCheckedPictureIndex = nUnCheckedPictureIndex;
}
//-------------------------------------------------------------------------------------
protected void DrawPrimitive()
{
 GE.DrawBox( X, Y, X+Width, Y+Height, PictureLayer, InnerColor, 
	    	   GameEngine.G_STYLE_FILL ); 	    
 GE.DrawBox( X, Y, X+Width, Y+Height, PictureLayer, OuterColor, 
   GameEngine.G_STYLE_STROKE );    
 
 if( CheckedFlag )
 {
   GE.DrawLine( X, Y + Height/2, X + Width/2, Y + Height, GE.LAYER_1 , OuterColor);
   GE.DrawLine( X + Width/2, Y + Height, X + Width, Y, GE.LAYER_1 , OuterColor);
 }	
}
//-------------------------------------------------------------------------------------
protected void DrawPicture()
{
  if( CheckedPictureIndex_TileX > -1 )
  {
    if( CheckedFlag )  
    	GameGlobals.DrawTileImageGeneralUltra( CheckedPictureIndex, (int)X, (int)Y, PictureLayer, AlphaValue, 
    			CheckedPictureIndex_TileX, CheckedPictureIndex_TileY, 
    	    	PictureWidthCells, PictureHeightCells, TileWidthPixels, TileHeightPixels );      	
    else	
    	GameGlobals.DrawTileImageGeneralUltra( UnCheckedPictureIndex, (int)X, (int)Y, PictureLayer, AlphaValue, 
    			UnCheckedPictureIndex_TileX, UnCheckedPictureIndex_TileY, 
    	    	PictureWidthCells, PictureHeightCells, TileWidthPixels, TileHeightPixels );     	
  }
  else
  {
	 if( CheckedFlag )  
	   GE.DrawImage( CheckedPictureIndex, (int)X, (int)Y, PictureLayer  );
     else
	   GE.DrawImage( UnCheckedPictureIndex, (int)X, (int)Y, PictureLayer  );	
  }
}
//-------------------------------------------------------------------------------------
public void Draw()
{
 if( DrawAltFlag == 1 )
 {
	 DrawAlt();
 }
 else
 {
  if( Style == STYLE_PRIMITIVE )
    DrawPrimitive();
  else
  if( Style == STYLE_PICTURE )
    DrawPicture();
 } 
}
//-------------------------------------------------------------------------------------
protected boolean CheckClickWithin()
{
boolean returnvalue = false;

if( X <= MouseX && MouseX < X + Width &&
    Y <= MouseY && MouseY < Y + Height )
    returnvalue = true;
return returnvalue;    
}
//-------------------------------------------------------------------------------------
public void OnClick() 
{
	int YesFlag = 0;

	if(( MouseStatus == ME_PRESS_DOWN || MouseStatus == ME_MOVE ) && CheckClickWithin() )
	{
		if( InputDelayMax > 0 )
		{
		  if( InputDelayCounter >= InputDelayMax )
		  {	
	        YesFlag = 1;
	        InputDelayCounter = 0;
		  }
		}
		else
		  YesFlag = 1;
		
		if( YesFlag == 1 )
		{
	        if( CheckedFlag )
	            CheckedFlag = false;
	        else
	            CheckedFlag = true;
	 
	        CopyDupInput();
	        OnClickDo();		
		}
		
	}
}
//-------------------------------------------------------------------------------------
protected void OnClickDo()
{
}
//-------------------------------------------------------------------------------------
public void Do()
{
  if( InputDelayCounter < InputDelayMax )
      InputDelayCounter++;	
}
//-------------------------------------------------------------------------------------
public void SetTileStyle( int nCheckedPictureIndex, int nUnCheckedPictureIndex, int nCheckedPictureIndex_TileX,
		   int nCheckedPictureIndex_TileY,  int nUnCheckedPictureIndex_TileX,  int nUnCheckedPictureIndex_TileY,
		   int nPictureWidthCells, int nPictureHeightCells, int nTileWidthPixels,
		   int nTileHeightPixels, int nAlphaValue )
{
		 CheckedPictureIndex = nCheckedPictureIndex;
		 UnCheckedPictureIndex = nUnCheckedPictureIndex;
		 CheckedPictureIndex_TileX = nCheckedPictureIndex_TileX;
		 CheckedPictureIndex_TileY = nCheckedPictureIndex_TileY;
		 UnCheckedPictureIndex_TileX = nUnCheckedPictureIndex_TileX;
		 UnCheckedPictureIndex_TileY = nUnCheckedPictureIndex_TileY;
		 PictureWidthCells = nPictureWidthCells;
		 PictureHeightCells = nPictureHeightCells;
		 TileWidthPixels = nTileWidthPixels;
		 TileHeightPixels = nTileHeightPixels;
		 AlphaValue = nAlphaValue; 	
}
//-------------------------------------------------------------------------------------
public CheckBox( int nX, int nY, int nWidth, int nHeight, int nGroupId, int nUniqueId, int nPictureLayer,
		int nPictureIndex, int nRowIndex0, int nRowIndex1, int nAlpha, boolean bCheckedFlag )
{
  super();  
  ClassType[TYPE_CHECKBOX] = 1;
  MouseEventNotifyFlag = true;
  CheckedFlag = bCheckedFlag;
  X = nX; Y = nY;  Width = nWidth; Height = nHeight;
  GroupId = nGroupId; UniqueId = nUniqueId;
  PictureLayer = nPictureLayer; 
  
int ScaledWidth = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * Width);
int ScaledHeight = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * Height);  

DrawAltFlag = 1;

SetTileStyle( nPictureIndex, nPictureIndex, 0, nRowIndex1,  0,  nRowIndex0,
		   1, 1, ScaledWidth, ScaledHeight, nAlpha );

}
//-------------------------------------------------------------------------------------
public void Set_TileX( int nPictureIndex0_TileX, int nPictureIndex1_TileX )
{
UnCheckedPictureIndex_TileX = nPictureIndex0_TileX; CheckedPictureIndex_TileX = nPictureIndex1_TileX;
}
//--------------------------------------------------------------------------
protected void DrawAlt()
{
 if( CheckedFlag )
     GameGlobals.DrawTileImageOne( CheckedPictureIndex, (int)X, (int)Y, PictureLayer, AlphaValue, CheckedPictureIndex_TileX, CheckedPictureIndex_TileY, 
    	 TileWidthPixels, TileHeightPixels );
 else
     GameGlobals.DrawTileImageOne( UnCheckedPictureIndex, (int)X, (int)Y, PictureLayer, AlphaValue, UnCheckedPictureIndex_TileX, UnCheckedPictureIndex_TileY, 
    	 TileWidthPixels, TileHeightPixels );        	
}
//-------------------------------------------------------------------------------------
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class RadioButton extends CheckBox
{

private final int MAX_RADIO_BUTTON_LIST_LENGTH = 12;
private RadioButton[] List;
private int ListCount;

//-------------------------------------------------------------------------------------
public RadioButton( int nX, int nY, boolean bCheckedFlag )
{
   super( nX, nY, bCheckedFlag );
   ClassType[TYPE_RADIO_BUTTON] = 1;
   ListCount = 0;
   List = new RadioButton[MAX_RADIO_BUTTON_LIST_LENGTH];
   PictureLayer = GE.LAYER_1; 
}
//-------------------------------------------------------------------------------------
protected void CopyDaisyChain( RadioButton DestRadio )
{
  int i;
  for( i = 0; i < MAX_RADIO_BUTTON_LIST_LENGTH; i++ )
     DestRadio.List[i] = List[i];
  DestRadio.ListCount = ListCount;
}
//-------------------------------------------------------------------------------------
public void Add2DaisyChain( RadioButton NewRadio )
{
  int i;
  for( i = 0; i < MAX_RADIO_BUTTON_LIST_LENGTH; i++ )
    if( List[i] == null )
    {
      List[i] = NewRadio;
      ListCount++;
      break;
    }

  for( i = 0; i < ListCount; i++ )
    if( List[i] != null && List[i] != this )
        CopyDaisyChain( List[i] ); 
}
//-------------------------------------------------------------------------------------
protected void DrawPrimitive()
{
 GE.DrawCircle( X + Width/2, Y + Height/2, Width/2, PictureLayer, InnerColor, GE.G_STYLE_FILL ); 
 
 if( CheckedFlag )
     GE.DrawCircle( X + Width/2, Y + Height/2, Width/3, PictureLayer, OuterColor, GE.G_STYLE_FILL );
}
//-------------------------------------------------------------------------------------
protected void OnClickDo()
{
  int i;
  for( i = 0; i < ListCount; i++ )
    if( List[i] != null && List[i] != this )
        List[i].CheckedFlag = false;
  CheckedFlag = true;
}
//------------------------------------------------------------------------------------- 
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class MultiStateButton extends GameObject
{
/*
enhanced verision of the ordinary button
*/

protected int MaxStates;
protected int FontSize;
protected int[] StateInnerColor;
protected int[] StateOuterColor;
protected String[] CaptionList;
protected int[] StatePictureIndex;
protected int ButtonState;
protected int Width, Height;

public static final int STYLE_PRIMITIVE = 1;
public static final int STYLE_PICTURE = 2;
public int DrawStyle;

protected int TilePictureIndex;
protected int [] TilePictureIndex_TileX, TilePictureIndex_TileY;
protected int PictureWidthCells, PictureHeightCells;
protected int TileWidthPixels, TileHeightPixels;
protected int AlphaValue;

protected int DrawAltFlag = 0;

//-------------------------------------------------------------------------------------
public MultiStateButton( int nX, int nY, int nWidth, int nHeight, int nMaxStates, int nFontSize )
{
	  super();
	  ClassType[TYPE_MULTI_STATE_BUTTON] = 1;
	  Name = new String("Multistate Button");
	  X = nX; Y = nY; Width = nWidth; Height = nHeight;
	  ButtonState = 0;
	  MaxStates = nMaxStates;
	  MouseEventNotifyFlag = true;
	  
	  DrawStyle = STYLE_PICTURE; 
	  
	  if( nFontSize > 0 )
	     FontSize = nFontSize;
	  else
	     FontSize = 18;	
	  
	  TextLayer = GE.LAYER_2;
	  PictureLayer = GE.LAYER_1;	
	  
	  TilePictureIndex_TileX = TilePictureIndex_TileY = null;
}
//-------------------------------------------------------------------------------------
public MultiStateButton( int[] nStatePictureList, String[] sCaptionList, 
	     int[] nStateInnerColor, int[] nStateOuterColor,
	     int nX, int nY, int nWidth, int nHeight, int nMaxStates, int nFontSize )
	{
	  super();
	  ClassType[TYPE_MULTI_STATE_BUTTON] = 1;
	  Name = new String("Multistate Button");
	  X = nX; Y = nY; Width = nWidth; Height = nHeight;
	  ButtonState = 0;
	  MaxStates = nMaxStates;
	  MouseEventNotifyFlag = true;
	  
	  int i;
	  
	  if( nFontSize > 0 )
	     FontSize = nFontSize;
	  else
	     FontSize = 18;
	   
	  if( nStatePictureList != null )
	  {  
	     StatePictureIndex = new int[MaxStates];
	     
	     for( i = 0; i < MaxStates; i++ )
	          StatePictureIndex[i] = nStatePictureList[i];
	     
	     DrawStyle = STYLE_PICTURE;     
	           
	  }
	  if( sCaptionList != null )
	  {
	     CaptionList = new String[MaxStates];
	     
	     for( i = 0; i < MaxStates; i++ )
	        CaptionList[i] = new String(sCaptionList[i]);
	     
	     DrawStyle = STYLE_PRIMITIVE;    
	  } 
	  if( nStateInnerColor != null )
	  {
	     StateInnerColor = new int[nStateInnerColor.length];
	     StateOuterColor = new int[nStateOuterColor.length];
	     
	     for( i = 0; i < nStateInnerColor.length; i++ )
	     {
	       StateInnerColor[i] = nStateInnerColor[i];
	       StateOuterColor[i] = nStateOuterColor[i];  
	     }
	  }
	  else
	  {
	     StateInnerColor = new int[nMaxStates];
	     StateOuterColor = new int[nMaxStates];  
	     
	     for( i = 0; i < MaxStates; i++ )
	     {
	       StateInnerColor[i] = Color.rgb(100,100,100);
	       StateOuterColor[i] = Color.rgb(255, 0, 0);     
	     }
	  }
	  
	  TextLayer = GE.LAYER_2;
	  PictureLayer = GE.LAYER_1;
	  
	  TilePictureIndex_TileX = TilePictureIndex_TileY = null;
	}
	//-------------------------------------------------------------------------------------
    public void SetMaxStates( int nMaxStates )
    {    	
    	MaxStates = nMaxStates;	
    }
    //-------------------------------------------------------------------------------------
    public void SetButtonState( int nButtonState )
    {    	
      ButtonState = nButtonState;
    }
    //-------------------------------------------------------------------------------------    
	public int GetButtonState()
	{
	   return ButtonState;
	}
	//-------------------------------------------------------------------------------------
	protected boolean CheckClickWithin()
	{
	boolean returnvalue = false;

	if( X <= MouseX && MouseX < X + Width &&
	    Y <= MouseY && MouseY < Y + Height )
	    returnvalue = true;
	return returnvalue;    
	}
	//-------------------------------------------------------------------------------------	
	protected void DrawState()
	{
if( DrawAltFlag == 1 )
{
  GameGlobals.DrawTileImageOne( TilePictureIndex, (int)X, (int)Y, PictureLayer, AlphaValue, TilePictureIndex_TileX[ButtonState], 
		   TilePictureIndex_TileY[ButtonState], TileWidthPixels, TileHeightPixels );	
}
else
{
	if( DrawStyle == STYLE_PRIMITIVE )
	{
	  GE.DrawBox( X, Y, X+Width, Y+Height, PictureLayer, StateOuterColor[ButtonState], 
	    GameEngine.G_STYLE_FILL );
	  GE.DrawBox( X+2, Y+2, X+Width-2, Y+Height-2, PictureLayer, StateInnerColor[ButtonState],
	    GameEngine.G_STYLE_FILL );
	  GE.DrawTextColor( CaptionList[ButtonState],(int)X+5, (int)Y+Height-10, 
	    TextLayer, StateOuterColor[ButtonState], FontSize );
	}
	else
	if( DrawStyle == STYLE_PICTURE )
	{
	  if( TilePictureIndex_TileX != null )
	      GameGlobals.DrawTileImageGeneralUltra( TilePictureIndex, (int)X, (int)Y, PictureLayer, AlphaValue, 
	    		    TilePictureIndex_TileX[ButtonState], TilePictureIndex_TileY[ButtonState], 
	    	    	PictureWidthCells, PictureHeightCells, TileWidthPixels, TileHeightPixels );  		  
	  else
	     GE.DrawImage( StatePictureIndex[ButtonState], (int)X, (int)Y, PictureLayer );    
	}
}

	}
	//-------------------------------------------------------------------------------------
	public void Draw()
	{  
	  DrawState();
	}
	//-------------------------------------------------------------------------------------
	public void OnClick() 
	{
		int YesFlag = 0;
		
		if( (MouseStatus == ME_PRESS_DOWN || MouseStatus == ME_MOVE )  && CheckClickWithin() )
		{
			if( InputDelayMax > 0 )
			{
			  if( InputDelayCounter >= InputDelayMax )
			  {		
	            YesFlag = 1;
		        InputDelayCounter = 0;
			  }

			}
			else
				YesFlag = 1;

		   if( YesFlag == 1)
		   {
	        ButtonState++;
	        if( ButtonState > MaxStates - 1 )
	           ButtonState = 0;
	        OnClickDo();
	        CopyDupInput();		
		   }	  
		}
		else 
		if( MouseStatus == ME_RELEASE )
		{  
		    OnUnClickDo();	    
		}
	}
	//-------------------------------------------------------------------------------------
	public void InstantClick()
	{
	  ButtonState++;
	  if( ButtonState > MaxStates - 1 )
	      ButtonState = 0;
	}
	//-------------------------------------------------------------------------------------	
	protected void OnClickDo()
	{
	}
	//-------------------------------------------------------------------------------------
	protected void OnUnClickDo()
	{
	}
	//-------------------------------------------------------------------------------------
	public void Do()
	{
	  if( InputDelayCounter < InputDelayMax )
	      InputDelayCounter++;	
	}
	//-------------------------------------------------------------------------------------		
	public void SetTileStyle( int nTilePictureIndex, int[] nTilePictureIndex_TileX,
			 int[] nTilePictureIndex_TileY,  
			 int nPictureWidthCells, int nPictureHeightCells, int nTileWidthPixels,
			 int nTileHeightPixels, int nAlphaValue )
	{
	
	  int i;
	  
	  TilePictureIndex = nTilePictureIndex;
	  TilePictureIndex_TileX = new int[MaxStates];
	  TilePictureIndex_TileY = new int[MaxStates];
	  
	  for( i = 0; i < MaxStates; i++ )
	  {
		TilePictureIndex_TileX[i] = nTilePictureIndex_TileX[i];
		TilePictureIndex_TileY[i] = nTilePictureIndex_TileY[i];		
	  }
	  
	  PictureWidthCells = nPictureWidthCells;
	  PictureHeightCells = nPictureHeightCells;
	  TileWidthPixels = nTileWidthPixels;
	  TileHeightPixels = nTileHeightPixels;
	  AlphaValue = nAlphaValue;
	}
	//-------------------------------------------------------------------------------------	
public MultiStateButton( int nX, int nY, int nWidth, int nHeight, int nGroupId, int nUniqueId, int nPictureLayer, int nTextLayer,
        int nMaxStates, int nPictureIndex, int nColumnIndex, int nRowStartIndex, int nAlphaValue )
{
   super();
   ClassType[TYPE_MULTI_STATE_BUTTON] = 1;
   Name = new String("Multistate Button");
   X = nX; Y = nY; Width = nWidth; Height = nHeight;
   ButtonState = 0;
   MaxStates = nMaxStates;
   MouseEventNotifyFlag = true;	  
   DrawStyle = STYLE_PICTURE; 

   Width = nWidth; Height = nHeight;
   X = nX; Y = nY; GroupId = nGroupId; UniqueId = nUniqueId;
   PictureLayer = nPictureLayer; TextLayer = nTextLayer;

   int i;
   int x = nColumnIndex, y = nRowStartIndex;
   int[] TileX = new int[MaxStates];
   int[] TileY = new int[MaxStates];

   for( i = 0; i < MaxStates; i++ )
   {
      TileX[i] = x; TileY[i] = y + i;
   }
   
int ScaledWidth = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * Width);
int ScaledHeight = (int)(GameControl.ImageScaleRelative_320x480[nPictureIndex] * Height);   

   SetTileStyle( nPictureIndex, TileX, TileY, 1, 1, ScaledWidth, ScaledHeight, nAlphaValue );

   DrawAltFlag = 1;
}
//-------------------------------------------------------------------------------------	
	}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class SimpleBackGround extends GameObject
{

  public final static int STYLE_FILL_COLOR = 1;
  public final static int STYLE_PICTURE_TILED = 2;
  public final static int STYLE_PICTURE_CENTER = 3;

  int Style;
  int FillColor;
  int PictureIndex;
  int PictureWidth, PictureHeight;

  protected int PictureIndex_TileX, PictureIndex_TileY;
  protected int PictureWidthCells, PictureHeightCells;
  protected int TileWidthPixels, TileHeightPixels;
  protected int AlphaValue;
  
  protected int XShift, YShift;

//------------------------------------------------------------------------------------- 
public SimpleBackGround()
{
  super();
  ClassType[TYPE_SIMPLE_BACKGROUND] = 1;
  PictureLayer = GE.LAYER_0;
  TextLayer = GE.LAYER_1;
  FillColor = Color.BLUE;

  Style = STYLE_FILL_COLOR;
  PictureIndex = GameControl.IMAGE_TILES_BACKGROUND;
  PictureIndex_TileX = PictureIndex_TileY = 0;
  
  SetTileStyle( GameControl.IMAGE_TILES_BACKGROUND, 0, 0, 1, 1, 48, 48, 255 );   
}
//-------------------------------------------------------------------------------------
public void SetProperties( int nStyle, int nFillColor, int nPictureIndex, 
        int nPictureWidth, int nPictureHeight )
{
  Style = nStyle; FillColor = nFillColor; PictureIndex = nPictureIndex; 
  PictureWidth = nPictureWidth; PictureHeight = nPictureHeight;
}                   
//-------------------------------------------------------------------------------------
public void Draw()
{
  int ix, iy;

  if( Style == STYLE_FILL_COLOR )
  {
     GE.DrawBox( 0, 0, ScreenWidth, ScreenHeight, PictureLayer, FillColor, 
	      GameEngine.G_STYLE_FILL );   
  }
  else
  if( Style == STYLE_PICTURE_TILED )
  { 
  
	if( PictureIndex_TileX > -1 )
	{
	 for( iy = 0; iy < ScreenHeight; iy += (PictureHeight-1) )
	   for( ix = 0; ix < ScreenWidth; ix += (PictureWidth-1) )		
	    GameGlobals.DrawTileImageOne( PictureIndex, ix, iy, PictureLayer, AlphaValue, 
	      PictureIndex_TileX, PictureIndex_TileY, TileWidthPixels, TileHeightPixels );  
	}
	else
	{
      for( iy = 0; iy < ScreenHeight; iy += (PictureHeight-1) )
       for( ix = 0; ix < ScreenWidth; ix += (PictureWidth-1) )
         GE.DrawImage( PictureIndex, ix, iy, PictureLayer );     
	}
  }
  else
  if( Style == STYLE_PICTURE_CENTER )
  {
    ix = ScreenWidth/2 - PictureWidth/2;
    iy = ScreenHeight/2 - PictureHeight/2;
      
    GE.DrawImage( PictureIndex, ix, iy, TextLayer );  
  }
}
//-------------------------------------------------------------------------------------
public void SetTileStyle( int nPictureIndex, int nPictureIndex_TileX, int nPictureIndex_TileY, 
		 int nPictureWidthCells, int nPictureHeightCells, int nTileWidthPixels,
		 int nTileHeightPixels, int nAlphaValue )
{
PictureIndex =  nPictureIndex;  
PictureIndex_TileX =  nPictureIndex_TileX;
PictureIndex_TileY = nPictureIndex_TileY;
PictureWidthCells = nPictureWidthCells; 	 
PictureHeightCells = nPictureHeightCells;
TileWidthPixels = nTileWidthPixels;
TileHeightPixels =nTileHeightPixels;
AlphaValue = nAlphaValue;
}
//------------------------------------------------------------------------------------- 
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class MenuCursorParallelia extends GameObject
{  

public static int
  MENU_A = 0, MENU_B = 1, MENU_C = 2, MENU_C2 = 3, MENU_D = 4, MENU_D_SUB = 5, MENU_E = 6, MENU_F = 7, MENU_G = 8,
  MENU_H = 9;

int MenuIndex, TilePictureIndex, AlphaValue;
int[] Menu_PosX, Menu_PosY, Menu_TileX, Menu_TileY;

public static int PIXELS_16 = 16, PIXELS_32 = 32, PIXELS_64 = 64, PIXELS_128 = 128;
public static int PIXELS_48 = 48, PIXELS_96 = 96, PIXELS_144 = 144, PIXELS_192 = 192;
public static int CELLS_1 = 1, CELLS_2 = 2, CELLS_3 = 3, CELLS_4 = 4;
int MenuSelectionIndex, MaxMenuSelectionIndex;

//-------------------------------------------------------------------------------------   
public MenuCursorParallelia( int nMenuIndex )
	{
	  super();
	  ClassType[TYPE_MENU_CURSOR_PARALLELIA] = 1;
	  Name = new String("Menu Cursor Parallelia");
	  X = 0; Y = 0;
	  KeyEventNotifyFlag = true;
	  
      MenuIndex = nMenuIndex;	        	  	  
	  TextLayer = GE.LAYER_4;
	  PictureLayer = GE.LAYER_4;
      
      SetTileStyle();
	}   
	//------------------------------------------------------------------------------------- 
	protected void DrawState()
	{
       int i = MenuSelectionIndex;
       
	   GameGlobals.DrawTileImageOne( TilePictureIndex, Menu_PosX[i], Menu_PosY[i], 
           PictureLayer, AlphaValue, Menu_TileX[i], Menu_TileY[i], (int)(PIXELS_48 * 1.5f), (int)(PIXELS_48 * 1.5f));  
	   
	}
	//-------------------------------------------------------------------------------------
	public void Draw()
	{  
	  DrawState();
	}
	//-------------------------------------------------------------------------------------
    protected void HandleKeyDown()
    {
     int IndexChange = 0;
    
        switch( KeyCode )
        {
          case KeyEvent.KEYCODE_DPAD_DOWN:
            IndexChange++;
            break;
          case KeyEvent.KEYCODE_DPAD_LEFT:
            IndexChange--;
            break;
          case KeyEvent.KEYCODE_DPAD_RIGHT:
            IndexChange++;
            break;
          case KeyEvent.KEYCODE_DPAD_UP:
            IndexChange--;
            break;
          case KeyEvent.KEYCODE_BACK:
            break;
          case KeyEvent.KEYCODE_ENTER:
          case KeyEvent.KEYCODE_DPAD_CENTER:
            MouseX = Menu_PosX[MenuSelectionIndex] + PIXELS_16; 
            MouseY = Menu_PosY[MenuSelectionIndex] + PIXELS_16;
            MouseStatus = ME_PRESS_DOWN;
            GE.TheControlManager.DoClickEvent( MouseStatus, MouseX, MouseY );
            break;
          default:
            break;
        }

      if( InputDelayCounter >= InputDelayMax )
      {
         InputDelayCounter = 0;
         MenuSelectionIndex += IndexChange;
      }
 
      if( MenuSelectionIndex < 0 )
          MenuSelectionIndex = 0;   
      else
      if( MenuSelectionIndex > MaxMenuSelectionIndex )
          MenuSelectionIndex = MaxMenuSelectionIndex;
    }
    //-------------------------------------------------------------------------------------
    protected void HandleKeyUp()
    {
     int IndexChange = 0;
    
        switch( KeyCode )
        {
          case KeyEvent.KEYCODE_DPAD_DOWN:
          case KeyEvent.KEYCODE_DPAD_LEFT:
          case KeyEvent.KEYCODE_DPAD_RIGHT:
          case KeyEvent.KEYCODE_DPAD_UP:
            break;
          case KeyEvent.KEYCODE_BACK:
            break;
          case KeyEvent.KEYCODE_ENTER:
          case KeyEvent.KEYCODE_DPAD_CENTER:
            MouseX = Menu_PosX[MenuSelectionIndex] + PIXELS_16; 
            MouseY = Menu_PosY[MenuSelectionIndex] + PIXELS_16;
            MouseStatus = ME_RELEASE;
            GE.TheControlManager.DoClickEvent( MouseStatus, MouseX, MouseY );
            break;
          default:
            break;
        }

         InputDelayCounter = InputDelayMax;
    }
    //-------------------------------------------------------------------------------------    
	public void OnKey() 
	{ 
      if( KeyStatus == ME_KEY_DOWN )
         HandleKeyDown();
      else
      if( KeyStatus == ME_KEY_UP )
         HandleKeyUp();  
	}
	//-------------------------------------------------------------------------------------
	public void Do()
	{
	  if( InputDelayCounter < InputDelayMax )
	      InputDelayCounter++;	         
	}
	//-------------------------------------------------------------------------------------	
	protected void InitArrays( int length )
	{
        Menu_PosX = new int[length];
        Menu_PosY = new int[length];
        Menu_TileX = new int[length];
        Menu_TileY = new int[length];
	}
	//-------------------------------------------------------------------------------------	
	protected void InitCursor( int Index, int PosX, int PosY, int TileX, int TileY )
	{
        Menu_PosX[Index] = PosX; Menu_PosY[Index] = PosY;
        Menu_TileX[Index] = TileX; Menu_TileY[Index] = TileY;
	}
	//-------------------------------------------------------------------------------------		
	protected void SetTileStyle()
	{
	  MenuSelectionIndex = 0;
      TilePictureIndex = GameControl.IMAGE_MENU_CURSOR;
      int x_shift_2x1 = PIXELS_96/2 - PIXELS_48/2;
      int x_shift_4x1 = PIXELS_192/2 - PIXELS_48/2;
      
      if( MenuIndex == MENU_A )
      {
        MaxMenuSelectionIndex = 3;
        InitArrays( MaxMenuSelectionIndex+1 );
        
        InitCursor( 0, 65 + x_shift_4x1,193,  0,0);
        InitCursor( 1, 65 + x_shift_4x1,256,  0,0);
        InitCursor( 2, 65 + x_shift_4x1,322,  0,0); 
      }
      else
      if( MenuIndex == MENU_B )
      {
        MaxMenuSelectionIndex = 2;
        InitArrays( MaxMenuSelectionIndex+1 );
        
        InitCursor( 0, 65 + x_shift_4x1,193,  0,0);
        InitCursor( 1, 65 + x_shift_4x1,256,  0,0);
        InitCursor( 2, 65 + x_shift_4x1,322,  0,0);          
      }
      else
      if( MenuIndex == MENU_C )
      {    	  
        MaxMenuSelectionIndex = 9;
        InitArrays( MaxMenuSelectionIndex+1 );
        
       InitCursor( 0, 212,81,  0,0);
       InitCursor( 1, 267,81,  0,0);
       InitCursor( 2, 212,146,  0,0);
       InitCursor( 3, 267,146,  0,0);
       InitCursor( 4, 238,211,  0,0);
       InitCursor( 5, 238,275,  0,0);

       InitCursor( 6, 214,342,  0,0);
       InitCursor( 7, 267,342,  0,0);
       
       InitCursor( 8, 109+x_shift_2x1,419,  0,0);
       InitCursor( 9, 253,419,  0,0);    	  
      }
      else
      if( MenuIndex == MENU_C2 )
      {    	  
        MaxMenuSelectionIndex = 5;
        InitArrays( MaxMenuSelectionIndex+1 ); 
        
        InitCursor( 0, 240,80,  0,0);
        InitCursor( 1, 240,154,  0,0);
        InitCursor( 2, 240,246,  0,0);
        InitCursor( 3, 240,324,  0,0);    
        InitCursor( 4, 13,419,  0,0);
        InitCursor( 5, 109+x_shift_2x1,419,  0,0);          
      }
      else
      if( MenuIndex == MENU_D )
      {    	  
        MaxMenuSelectionIndex = 4;
        InitArrays( MaxMenuSelectionIndex+1 );  
        
        InitCursor( 0, 40,357,  0,0);
        InitCursor( 1, 100,357,  0,0);
        InitCursor( 2, 160,357,  0,0);
        InitCursor( 3, 220,357,  0,0);
        InitCursor( 4, 104 + x_shift_2x1,416,  0,0);        
      }
      else
      if( MenuIndex == MENU_D_SUB )
      {    	  
        MaxMenuSelectionIndex = 0;
        InitArrays( MaxMenuSelectionIndex+1 ); 
        InitCursor( 0, 104 + x_shift_2x1,200,  0,0);
      }      
      else
      if( MenuIndex == MENU_E )
      {    	  
        MaxMenuSelectionIndex = 2;
        InitArrays( MaxMenuSelectionIndex+1 );   
        InitCursor( 0, 13,419,  0,0 );
        InitCursor( 1, 109 + x_shift_2x1,419,  0,0);
        InitCursor( 2, 253,419,  0,0);        
      }
      else
      if( MenuIndex == MENU_F )
      {    	  
      }
      else
      if( MenuIndex == MENU_G )
      {
        MaxMenuSelectionIndex = 0;
        InitArrays( MaxMenuSelectionIndex+1 ); 
        InitCursor( 0, 109+x_shift_2x1,419,  0,0);    	  
      }
      else
      if( MenuIndex == MENU_H )
      {
        MaxMenuSelectionIndex = 2;
        InitArrays( MaxMenuSelectionIndex+3 ); 
        InitCursor( 0, 109 + x_shift_2x1,419,  0,0);    	  
        InitCursor( 1, 109+96,419,  0,0 );
        InitCursor( 2, 109+96+48,419,  0,0);
      }      
      
      AlphaValue = 128;
	}
	//-------------------------------------------------------------------------------------	
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class CellSampleDisplay extends GameObject
{
public static int RowIndex0 = 0, RowIndex1 = 0;
public int PictureIndex0, PictureIndex1;

public final static int CELL_WIDTH_PIXELS = 20;
public final static int CELL_HEIGHT_PIXELS = 20;

//-------------------------------------------------------------------------------------
public CellSampleDisplay( int nX, int nY )
{
  super();
  ClassType[TYPE_CELL_SAMPLE_DISPLAY] = 1;
  PictureLayer = GE.LAYER_2;
  X = nX; Y = nY;
  PictureIndex0 = GameControl.IMAGE_TILES_FOUR_LAYER;
  PictureIndex1 = GameControl.IMAGE_TILES_ONE_LAYER;
}
//-------------------------------------------------------------------------------------
public void Draw()
{
  int x, y;

  for( x = 0; x <= 3; x++ )
    GameGlobals.DrawTileImageOne( PictureIndex0, (int)(X + x * CELL_WIDTH_PIXELS), (int)Y, PictureLayer, 255, x, RowIndex0,
	    	CELL_WIDTH_PIXELS, CELL_HEIGHT_PIXELS);

  for( x = 0; x <= 7; x++ )
    GameGlobals.DrawTileImageOne( PictureIndex1, (int)(X + x * CELL_WIDTH_PIXELS), (int)Y + CELL_HEIGHT_PIXELS * 4, PictureLayer, 255, x, RowIndex1,
	    	CELL_WIDTH_PIXELS, CELL_HEIGHT_PIXELS);
}
//-------------------------------------------------------------------------------------
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
class ControlManager
{
  protected GameObject[] ControlList;
  protected final static int CONTROL_LIST_LENGTH = 200;
  protected int i;
  
  MenuCursorParallelia ItsMenuCursorParallelia = null;
  CaptionBox EulaCaptionBox = null;
  
  GameGlobals gg;
  GameEngine GE;
  protected int CaptionDistanceBetweenLines = 15;
  int DoneLoadingFlag = 0;

//-------------------------------------------------------------------------------------
  public ControlManager()
  {
	ControlList = new GameObject[CONTROL_LIST_LENGTH];
	gg = new GameGlobals();
	gg.GE = GameEngine.CurrentObj;
	GE = GameEngine.CurrentObj;
  }
//-------------------------------------------------------------------------------------  
  protected void AddControl( GameObject obj )
  {
    for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
      if( ControlList[i] == null )
      {
          ControlList[i] = obj;
          break;
      }    
  }  
//-------------------------------------------------------------------------------------
  public Button AddButton( int X, int Y, int Width, int Height, int GroupId, int UniqueId, int ImageIndex )
  {	  
	 Button Button1;
	 Button1 = new Button("button", X, Y, Width, Height);
	 Button1.GroupId = GroupId;
	 Button1.UniqueId = UniqueId;
	 Button1.SetLayers( GE.LAYER_2, GE.LAYER_1 );
	 Button1.SetPressedStyle( Button.STYLE_PICTURE, Color.rgb(0,0,0), Color.rgb(0,0,0), ImageIndex, 
			  Color.rgb(0,0,0) );	  
	 Button1.SetReleasedStyle( Button.STYLE_PICTURE, Color.rgb(0,0,0), Color.rgb(0,0,0), ImageIndex, 
			  Color.rgb(0,0,0) );		  
     AddControl(Button1);	  
     return Button1;
  }     
//-------------------------------------------------------------------------------------    
  public MultiStateButton AddMultiStateButton( int X, int Y, int Width, int Height,
		   int GroupId, int UniqueId, int[] ImageList, int MaxStates )
		{
	      int FontSize = 30;
		  MultiStateButton msb;
		  msb = new MultiStateButton( ImageList, null, null, null,
					     X, Y, Width, Height, MaxStates, FontSize );
		  msb.GroupId = GroupId;
		  msb.UniqueId = UniqueId;   

		  AddControl(msb);              
		  return msb;                 
		} 
//-------------------------------------------------------------------------------------  
  public Caption AddCaption( int X, int Y, String sText, int nFontSize, int nFontColor, 
		     int nRelativeX, int nRelativeY, boolean bMultiLineFlag, int nPictureIndex,
		     int nGroupId, int nUniqueId )
		{
		   Caption Caption1 = null;

		    if( sText != null && nPictureIndex > 0 )
		    {
			  Caption1 = new Caption( X, Y, sText );
		      Caption1.SetTextOptions( nFontSize, nFontColor, nRelativeX, nRelativeY, bMultiLineFlag, 
		        CaptionDistanceBetweenLines );    
		      Caption1.SetTextPicture( sText, nPictureIndex );
		    }
		    else
		    if( sText != null )
		    {
			  Caption1 = new Caption( X, Y, sText );
		      Caption1.SetTextOptions( nFontSize, nFontColor, nRelativeX, nRelativeY, bMultiLineFlag, 
		        CaptionDistanceBetweenLines );
		    }
		    else
		    if( nPictureIndex > 0 )
		    {
		      Caption1 = new Caption( X, Y, nPictureIndex );
		    }
		   	Caption1.GroupId = nGroupId;	
			Caption1.UniqueId = nUniqueId;
		    Caption1.SetLayers( GE.LAYER_2, GE.LAYER_1 );
			AddControl(Caption1);	      
		    return Caption1;  
		}  
//------------------------------------------------------------------------------------- 
public Caption AddPictureCaption( int x, int y, int nPictureIndex, 
		  int nPictureIndex_TileX, int nPictureIndex_TileY,
		  int nPictureWidthCells, int nPictureHeightCells,
		  int nTileWidthPixels, int nTileHeightPixels,
		  int nAlphaValue )
{
   Caption cap = new Caption( x, y, nPictureIndex );
   
   cap.SetTileStyle( nPictureIndex, 
		  nPictureIndex_TileX, nPictureIndex_TileY,
		  nPictureWidthCells, nPictureHeightCells,
		  nTileWidthPixels, nTileHeightPixels,
		  nAlphaValue );
   
   AddControl(cap);	        
   return cap;
}
//-------------------------------------------------------------------------------------
  // *** replaceable in descendant class ***
  public void CreateMenuA()
  {	  
	  Caption Caption1;
	  Button Button1;	  
	  Destroy(0, 0);
	 
      Caption1 = new Caption( 19, 65, gg.GROUP_ID_MENU_A, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_PICTURE, GE.LAYER_2, GE.LAYER_3 );
      Caption1.Init_2(  GameControl.IMAGE_MAIN_TITLE_10, 280, 82, GameGlobals.InterfaceStyleIndex, 255, 1 );
	  AddControl(Caption1);		  
   
	  Button1 = new Button( "Start", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 65, 193, 194, 48, gg.GROUP_ID_MENU_A, gg.UNIQUE_ID_BUTTON_START, GE.LAYER_2, GE.LAYER_1, 
        GameControl.IMAGE_TILES_4x1, 0, 0, 255 );
	  Button1.Set_TileX(GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex);
      AddControl(Button1);      
      
      Button1 = new Button( "Options", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 65, 193 + 63 * 1, 194, 48, gg.GROUP_ID_MENU_A, gg.UNIQUE_ID_BUTTON_OPTIONS, GE.LAYER_2, GE.LAYER_1, 
        GameControl.IMAGE_TILES_4x1, 1, 1, 255 );
	 Button1.Set_TileX(GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex);
      AddControl(Button1);
      
      Button1 = new Button( "High Scores", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 65, 193 + 63 * 2, 194, 48, gg.GROUP_ID_MENU_A, gg.UNIQUE_ID_BUTTON_HIGH_SCORES, GE.LAYER_2, GE.LAYER_1, 
        GameControl.IMAGE_TILES_4x1, 2, 2, 255 );
	  Button1.Set_TileX(GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex);
      AddControl(Button1);
      
      CopyRightCaption cpc = new CopyRightCaption();
      AddControl(cpc);
      
      if( GameGlobals.TVModeFlag > 0 )
          ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_A );
/*      
      AddPictureCaption( GameEngine.TARGET_SCREEN_WIDTH - 48,  GameEngine.TARGET_SCREEN_HEIGHT - 48, GameGlobals.IMAGE[61], 
		  3,0,  1,1,  48,48,  128 );
*/
  }
//-------------------------------------------------------------------------------------
  // *** replaceable in descendant class ***
  public void CreateMenuB()
  {	
	  Caption Caption1;
	  Button Button1;	  
	  Destroy(0, 0);
	  
      Caption1 = new Caption( 19, 65, gg.GROUP_ID_MENU_B, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_PICTURE, GE.LAYER_2, GE.LAYER_3 );
      Caption1.Init_2(  GameControl.IMAGE_MAIN_TITLE_10, 280, 82, GameGlobals.InterfaceStyleIndex, 255, 1 );
	  AddControl(Caption1);		  

	  Button1 = new Button( "Start", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 65, 193, 194, 48, gg.GROUP_ID_MENU_B, gg.UNIQUE_ID_BUTTON_GAME_ORIGINAL, GE.LAYER_2, GE.LAYER_1, 
        GameControl.IMAGE_TILES_4x1, 4, 4, 255 );
	  Button1.Set_TileX(GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex);
      AddControl(Button1);      
      
      Button1 = new Button( "Options", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 65, 193 + 63 * 1, 194, 48, gg.GROUP_ID_MENU_B, gg.UNIQUE_ID_BUTTON_GAME_CHALLENGE, GE.LAYER_2, GE.LAYER_1, 
        GameControl.IMAGE_TILES_4x1, 5, 5, 255 );
	  Button1.Set_TileX(GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex);
      AddControl(Button1);
      
      Button1 = new Button( "High Scores", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 65, 193 + 63 * 2, 194, 48, gg.GROUP_ID_MENU_B, gg.UNIQUE_ID_BUTTON_GAME_TRADITIONAL, GE.LAYER_2, GE.LAYER_1, 
        GameControl.IMAGE_TILES_4x1, 6, 6, 255 );
	  Button1.Set_TileX(GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex);
      AddControl(Button1);
      
      
      if( GameGlobals.TVModeFlag > 0 )
          ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_B );
  }
//-------------------------------------------------------------------------------------
  // *** replaceable in descendant class ***
  public void CreateMenuC()
  {	  
	  Caption Caption1;
	  Button Button1;	  
	  CheckBox CheckBox1;
	  MultiStateButton MultiStateButton1;
	  Destroy(0, 0);
	    
      Caption1 = new Caption( GameEngine.TARGET_SCREEN_WIDTH/3, 10, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Options", gg.HeaderFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		  
	  	  
      Caption1 = new Caption( 20, 81, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_CAPTION_OPTION_SPEED, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Speed " + gg.GameSpeed, gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		  

      Caption1 = new Caption( 20, 148, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_CAPTION_OPTION_PIT_COUNT, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Pit Count " + gg.PitCount, gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);	
	  
      Caption1 = new Caption( 20, 212, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_NONE, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Sounds", gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		  
	  
      Caption1 = new Caption( 20, 277, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_NONE, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Rough Floor", gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		 
  
      Caption1 = new Caption( 20, 344, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_NONE, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Background", gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		  	  

      Button1 = new Button( "Okay", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 109, 419, 96, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_BUTTON_OPTION_OKAY, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_2x1, GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex, 255 );	  
      AddControl(Button1);          
     	      
      Button1 = new Button( "+", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 212, 81, 48, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_BUTTON_OPTION_INC_SPEED, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 16, 16, 255 );	
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);      
      
      Button1 = new Button( "-", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 267, 81, 48, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_BUTTON_OPTION_DEC_SPEED, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 17, 17, 255 );	  
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);    
	  
      Button1 = new Button( "+", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 212, 146, 48, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_BUTTON_OPTION_INC_PIT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 16, 16, 255 );	  
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);           
      
      Button1 = new Button( "-", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 267, 146, 48, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_BUTTON_OPTION_DEC_PIT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 17, 17, 255 );	  
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);        
     
      CheckBox1 = new CheckBox( 238, 211, 48, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_CHECKBOX_OPTION_SOUNDS, GE.LAYER_2, 
        GameControl.IMAGE_TILES_1x1, 19, 18, 255, false );
      CheckBox1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );        
	  AddControl(CheckBox1);
	  
	  if( gg.SoundsFlag > 0 )
		  CheckBox1.CheckedFlag = true;
	  else
		  CheckBox1.CheckedFlag = false;
	  
      CheckBox1 = new CheckBox( 238, 275, 48, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_CHECKBOX_OPTION_GARBAGE, GE.LAYER_2, 
        GameControl.IMAGE_TILES_1x1, 19, 18, 255, false );
      CheckBox1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );        
	  AddControl(CheckBox1);	  
	  
	  if( gg.GarbageBlocksFlag > 0 )
		  CheckBox1.CheckedFlag = true;
	  else
		  CheckBox1.CheckedFlag = false;
	  
	  AddControl(CheckBox1);	  

	int Digit1, Digit2;

    Digit1 = GameGlobals.BackGroundIndex % 10;
    Digit2 = GameGlobals.BackGroundIndex / 10;
    	
    MultiStateButton1 = new MultiStateButton( 212,342,  48,48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_1,
            GE.LAYER_2, GE.LAYER_1, 10, GameControl.IMAGE_TILES_1x1, GameGlobals.InterfaceStyleIndex, 0, 255); 
    MultiStateButton1.ButtonState = Digit1;    	
    AddControl(MultiStateButton1);	  
    
    MultiStateButton1 = new MultiStateButton( 267,342,  48,48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_2,
            GE.LAYER_2, GE.LAYER_1, 10, GameControl.IMAGE_TILES_1x1, GameGlobals.InterfaceStyleIndex, 0, 255); 
    MultiStateButton1.ButtonState = Digit2;    	
    AddControl(MultiStateButton1);	  
	  
      Button1 = new Button( ">>", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 253, 419, 48, 48, gg.GROUP_ID_MENU_C, gg.UNIQUE_ID_BUTTON_OPTION_RIGHT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 13, 13, 255 );	  
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);  	  
	  	  
	  if( GameGlobals.TVModeFlag > 0 )
	      ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_C );
  }
//-------------------------------------------------------------------------------------
  // *** replaceable in descendant class ***
  public void CreateMenuC2()
  {
	  Destroy(0, 0);
	  Caption Caption1;
	  MultiStateButton MultiStateButton1;
	  Button Button1;
	  int gid = gg.GROUP_ID_MENU_C2;
	  
      Caption1 = new Caption( GameEngine.TARGET_SCREEN_WIDTH/3, 10, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Options", gg.HeaderFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		  
	  	  
      Caption1 = new Caption( 20, 81, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Group Colors A", gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		 	  
      Caption1 = new Caption( 20, 154, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Group Colors B", gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);	
      Caption1 = new Caption( 20, 244, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Interface Style", gg.RegularFontSize1, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);	
/*
      Caption1 = new Caption( 20, 324, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_BUTTON_OPTION_RANDOM_METHOD_CAP_0, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Random Type:\nBag", gg.RegularFontSize1, gg.MainFontColor, 0, 20, true, 15 ); 
	  AddControl(Caption1);		  

	  if(  GameGlobals.UseClassicRandomMethodFlag >= 1 )
		   Caption1.SetText("Random Type:\nClassic");
	  else
	      Caption1.SetText("Random Type:\nBag");
*/	  
	  CellSampleDisplay csd = new CellSampleDisplay( 30, 125 );
	  csd.RowIndex0 =  GameGlobals.TileImageIndex_2_CellStartY_1;
	  csd.RowIndex1 =  GameGlobals.TileImageIndex_2_CellStartY_2;
	  AddControl(csd);
     
     MultiStateButton1 = new MultiStateButton( 240,80,  48,48, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_MSB,
            GE.LAYER_2, GE.LAYER_1, 10, GameControl.IMAGE_TILES_1x1, GameGlobals.InterfaceStyleIndex, 0, 255); 
     MultiStateButton1.ButtonState = GameGlobals.TileImageIndex_2_CellStartY_1;    	
     AddControl(MultiStateButton1);	    
     MultiStateButton1 = new MultiStateButton( 240,154,  48,48, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_MSB,
            GE.LAYER_2, GE.LAYER_1, 10, GameControl.IMAGE_TILES_1x1, GameGlobals.InterfaceStyleIndex, 0, 255); 
     MultiStateButton1.ButtonState = GameGlobals.TileImageIndex_2_CellStartY_2;    	
     AddControl(MultiStateButton1);	    
     MultiStateButton1 = new MultiStateButton( 240,246,  48,48, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_BUTTON_OPTION_INTERFACE_COLORS_MSB,
            GE.LAYER_2, GE.LAYER_1, 10, GameControl.IMAGE_TILES_1x1, GameGlobals.InterfaceStyleIndex, 0, 255); 
     MultiStateButton1.ButtonState = GameGlobals.InterfaceStyleIndex;    	
     AddControl(MultiStateButton1);	 
/*     
     MultiStateButton1 = new MultiStateButton( 240,324,  48,48, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_BUTTON_OPTION_RANDOM_METHOD_MSB,
            GE.LAYER_2, GE.LAYER_1, 2, GameControl.IMAGE_TILES_1x1, GameGlobals.InterfaceStyleIndex, 0, 255); 
     MultiStateButton1.ButtonState = GameGlobals.UseClassicRandomMethodFlag;    	
     AddControl(MultiStateButton1);	         
*/	  
      Button1 = new Button( "Okay", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 109, 419, 96, 48, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_BUTTON_OPTION_OKAY, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_2x1, GameGlobals.InterfaceStyleIndex, 0, 255 );	  
      AddControl(Button1);        
      
      Button1 = new Button( "<-", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 13, 419, 48, 48, gg.GROUP_ID_MENU_C2, gg.UNIQUE_ID_BUTTON_OPTION_LEFT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 12, 12, 255 );	  
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex ); 
      AddControl(Button1);        
            
	  
	  if( GameGlobals.TVModeFlag > 0 )
	      ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_C2 );	  
  }
//-------------------------------------------------------------------------------------
  // *** replaceable in descendant class ***  
  public void CreateMenuD()
  {
	  Caption Caption1;
	  Button Button1;	  
	  Destroy(0, 0);
	   
	  int[] wh = new int[2];
	  
      Caption1 = new Caption( GameEngine.TARGET_SCREEN_WIDTH/3, 60, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "Game Over", gg.HeaderFontSize2, gg.MainFontColor, 0, 20, false, 15 ); 
	  AddControl(Caption1);		
	  
	  if( gg.CheckNewHighScore() ) 
	  {		  	
	    
        Caption1 = new Caption( GameEngine.TARGET_SCREEN_WIDTH/4, 140, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
        Caption1.Init_1( "New High Score!\n" + gg.CurrentPlayerScore, gg.HeaderFontSize1, gg.MainFontColor, 0, 40, true, 20 );
	    AddControl(Caption1);			    
	    
	    GameGlobals.CurrentPlayerName = GameGlobals.repeat("-", GameGlobals.MAX_HIGH_SCORE_NAME_LENGTH );
	    	
        Caption1 = new Caption( GameEngine.TARGET_SCREEN_WIDTH/4, 250, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
        Caption1.Init_1( "Enter your name", gg.HeaderFontSize1, gg.MainFontColor, 0, 40, false, 15 ); 
	    AddControl(Caption1);			    

        Caption1 = new Caption( GameEngine.TARGET_SCREEN_WIDTH/4, 300, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_CAPTION_GAME_OVER_NAME, Caption.STYLE_TEXT, -1, -1 );
        Caption1.Init_1( GameGlobals.CurrentPlayerName, gg.HeaderFontSize2, gg.MainFontColor, 0, 40, false, 15 );
        Caption1.DrawCursorFlag = true;
	    AddControl(Caption1);		    

      Button1 = new Button( "<", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 40, 357, 48, 48, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_BUTTON_GAME_OVER_LEFT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 12, 12, 255 );	  
	  Button1.InputDelayMax = 5;
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);      
        
      Button1 = new Button( "^", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 100, 357, 48, 48, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_BUTTON_GAME_OVER_UP, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 11, 11, 255 );	  
	  Button1.InputDelayMax = 5;
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);         
        
      Button1 = new Button( "\\/", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 160, 357, 48, 48, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_BUTTON_GAME_OVER_DOWN, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 10, 10, 255 );	  
	  Button1.InputDelayMax = 5;
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);    

      Button1 = new Button( ">", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 220, 357, 48, 48, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_BUTTON_GAME_OVER_RIGHT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 13, 13, 255 );	  
	  Button1.InputDelayMax = 5;
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);    

        
      Button1 = new Button( "Okay", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 104, 416, 96, 48, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_BUTTON_GAME_OVER_OKAY_ADD_SCORE, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_2x1, GameGlobals.InterfaceStyleIndex, 0, 255 );	  
      AddControl(Button1);  
      
	  if( GameGlobals.TVModeFlag > 0 )
	      ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_D );        
	  }
	  else
	  {		          
        
      Button1 = new Button( "Okay", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 104, 200, 96, 48, gg.GROUP_ID_MENU_D, gg.UNIQUE_ID_BUTTON_GAME_OVER_OKAY, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_2x1, GameGlobals.InterfaceStyleIndex, 0, 255 );	  
      AddControl(Button1);            
        
        
	  if( GameGlobals.TVModeFlag > 0 )
	      ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_D_SUB );        
	  }
	  
  }
//-------------------------------------------------------------------------------------  
  // *** replaceable in descendant class ***
  public void CreateMenuE()
  {
	  Caption Caption1;
	  Button Button1;	  
	  Destroy(0, 0);
	  
	  Caption1 = new Caption( 63, 10, gg.GROUP_ID_MENU_E, gg.UNIQUE_ID_CAPTION_GENERAL, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "High Scores", gg.HeaderFontSize1, gg.MainFontColor, 0, 40, false, 20 ); 
	  AddControl(Caption1);			    
	  
	  Caption1 = new Caption( 63, 70, gg.GROUP_ID_MENU_E, gg.UNIQUE_ID_CAPTION_HIGH_SCORES_LIST, Caption.STYLE_TEXT, -1, -1 );
      Caption1.Init_1( "High Scores", gg.RegularFontSize1, gg.MainFontColor, 0, 40, true, 20 ); 	  
      Caption1.SetText( gg.SelectHighScoreBoardtoString(0) );
	  AddControl(Caption1);		 
      
      Button1 = new Button( "Okay", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 109, 419, 96, 48, gg.GROUP_ID_MENU_E, gg.UNIQUE_ID_BUTTON_HIGH_SCORES_OKAY, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_2x1, GameGlobals.InterfaceStyleIndex, 0, 255 );	  
      AddControl(Button1);            
      
      Button1 = new Button( "<", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 13, 419, 48, 48, gg.GROUP_ID_MENU_E, gg.UNIQUE_ID_BUTTON_HIGH_SCORES_LEFT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 12, 12, 255 );	  
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);       
      
      Button1 = new Button( ">", 0,0,0,0 );
	  Button1.Create_WidthxHeight( 253, 419, 48, 48, gg.GROUP_ID_MENU_E, gg.UNIQUE_ID_BUTTON_HIGH_SCORES_RIGHT, GE.LAYER_2, GE.LAYER_1, 
      GameControl.IMAGE_TILES_1x1, 13, 13, 255 );	  
	  Button1.Set_TileX( GameGlobals.InterfaceStyleIndex, GameGlobals.InterfaceStyleIndex );
      AddControl(Button1);        
      
	  if( GameGlobals.TVModeFlag > 0 )
	      ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_E );      
  }
//-------------------------------------------------------------------------------------  
// *** replaceable in descendant class ***
  public void CreateMenuF()
  {
	  BlockGameEngine bge;	 
	  Destroy(0, 0);	
	  bge = new BlockGameEngine();
	  bge.UniqueId = gg.UNIQUE_ID_BLOCK_GAME_ENGINE_1;	  
	  bge.GroupId = gg.GROUP_ID_MENU_F;
	  AddControl(bge);	  
	  ItsMenuCursorParallelia = null;
  }
//------------------------------------------------------------------------------------- 
// *** replaceable in descendant class ***
  public void CreateMenuG()
  {
	 Caption Caption1;
	 Button Button1;	  
	 Destroy(0, 0);
	 
	 Button1 = AddButton( 109, 419, 96, 48, gg.GROUP_ID_MENU_G, gg.UNIQUE_ID_BUTTON_ABOUT_OKAY, 48 );
	 Button1.SetLayers( GE.LAYER_2, GE.LAYER_2 );
     Caption1 = AddCaption( 0,0,  null, 15, 0xFFFFFF,  0,0,  false,  62,  0,0 );
     Caption1.SetLayers( GE.LAYER_1, GE.LAYER_1 );
     
      
	 if( GameGlobals.TVModeFlag > 0 )
	     ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_G );  	  	  
  }
//------------------------------------------------------------------------------------- 
// *** replaceable in descendant class ***
public void CreateMenuH()
{
   CaptionBox cb;
   Button Button1;	  
   Destroy(0, 0);	
/*   
   cb = new CaptionBox( 15, Color.rgb(200,200,200), 24,50, 270, 349, Color.rgb(0,0,0) );
   Button1 = AddButton( 109, 419, 96, 48, gg.GROUP_ID_MENU_H, gg.UNIQUE_ID_BUTTON_ABOUT_EULA_OKAY, 48 );
   Button1 = AddButton( 109+96, 419, 48, 48, gg.GROUP_ID_MENU_H, gg.UNIQUE_ID_BUTTON_ABOUT_EULA_UP, 48 );
   Button1 = AddButton( 109+96+48, 419, 48, 48, gg.GROUP_ID_MENU_H, gg.UNIQUE_ID_BUTTON_ABOUT_EULA_DOWN, 48 );
   	 	
   GE.FileName =  "raw:"+R.raw.eula;	        	      
   GE.FileOperationFlag = GE.G_REQUEST_READ_FILE;
   GameEngine.CurrentObj.DoRequest(GameEngine.CurrentObj.G_REQUEST_READ_FILE);
   
   cb.SetText( GE.FileDataStr );   
   AddControl( cb );   
   SetGameObjectImages();
   
   EulaCaptionBox = cb;
    
   if( GameGlobals.TVModeFlag > 0 )
	   ItsMenuCursorParallelia = new MenuCursorParallelia( MenuCursorParallelia.MENU_H );   
*/   
}
//-------------------------------------------------------------------------------------  
// *** replaceable in descendant class ***
  public void Init() 
  { 
     GameGlobals.CalculateFontSize();	  
	 CreateMenuA();
  }
//-------------------------------------------------------------------------------------  
  public void DoClickEvent( int TouchAction, int TouchX, int TouchY ) 
  {    
    GameObject.MouseStatus = TouchAction;
    GameObject.MouseX = TouchX;
    GameObject.MouseY = TouchY;

    for( i = 0; i < CONTROL_LIST_LENGTH; i++ ) 
      if( ControlList[i] != null )
       if( ControlList[i].MouseEventNotifyFlag )      
    	  ControlList[i].OnClick();  
  }
//-------------------------------------------------------------------------------------  
  public void DoKeyEvent( int KeyAction, int KeyCode )  
  {
    GameObject.KeyStatus = KeyAction;
    GameObject.KeyCode = KeyCode;
    
    if( ItsMenuCursorParallelia != null )
        ItsMenuCursorParallelia.OnKey();
         
    for( i = 0; i < CONTROL_LIST_LENGTH; i++ ) 
      if( ControlList[i] != null )
       if( ControlList[i].KeyEventNotifyFlag )      
    	  ControlList[i].OnKey();     
  }  
//-------------------------------------------------------------------------------------
  protected GameObject FindFirstControlById( int UniqueId )
  {	
	GameObject obj = null;
	
	for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
	  if( ControlList[i] != null )
	   if( ControlList[i].UniqueId == UniqueId )
	   {
		  obj = ControlList[i];
		  break;
	   }
	
	return obj;
  }
//-------------------------------------------------------------------------------------  
// *** replaceable in descendant class ***
  protected void CheckControlListState() 
  {
    int UniqueId, GroupId;
    GameObject go;
    Caption cap;
    MultiStateButton msb;
    int Digit1 = 0, Digit2 = 0;
    
    for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
     if( ControlList[i] != null )
     {  
       go = ControlList[i];
       UniqueId = go.UniqueId;
       GroupId = go.GroupId;
       
       if( go.MouseStatus_Dup == go.ME_PRESS_DOWN ||
    	   go.MouseStatus_Dup == go.ME_MOVE )
       {
    	switch( UniqueId )
    	{
    	  //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_START:
    		if( GameGlobals.LoadGameFileFlag > 0 )
    		{
    	        CreateMenuF();    			
    		}
    		else
              CreateMenuB();
            break;
          //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTIONS:
        	CreateMenuC();
            break; 
          //---------------------------------------------------------------------        
    	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES:     	
        	CreateMenuE();
            break;
          //---------------------------------------------------------------------  
        case GameGlobals.UNIQUE_ID_BUTTON_ABOUT:
        	CreateMenuG();
        	break;        	
          //---------------------------------------------------------------------
        case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA:
        	CreateMenuH();
        	break;
          //---------------------------------------------------------------------  
        case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA_OKAY: 	
        case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_OKAY:
        	CreateMenuA();
        	break;       	
          //---------------------------------------------------------------------            
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_INC_SPEED:

        	gg.GameSpeed++;        	
        	if( gg.GameSpeed > gg.MAX_GAME_SPEED )
        		gg.GameSpeed = gg.MAX_GAME_SPEED;   

        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_OPTION_SPEED);
        	cap.SetText( "Speed " + gg.GameSpeed );        	
        	
        	break;
        	//---------------------------------------------------------------------        	
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_DEC_SPEED:
      
        	gg.GameSpeed--;        	
        	if( gg.GameSpeed < gg.MIN_GAME_SPEED )
        		gg.GameSpeed = gg.MIN_GAME_SPEED; 
        	
        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_OPTION_SPEED);
        	cap.SetText( "Speed " + gg.GameSpeed );

        	break;
        	//---------------------------------------------------------------------        	
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_INC_PIT:

        	gg.PitCount++;        	
        	if( gg.PitCount > gg.MAX_PIT_COUNT )
        		gg.PitCount = gg.MAX_PIT_COUNT;  

        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_OPTION_PIT_COUNT);
        	cap.SetText( "Pit Count " + gg.PitCount );        	

    	   break;
    	  //---------------------------------------------------------------------    	   
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_DEC_PIT:

        	gg.PitCount--;        	
        	if( gg.PitCount < gg.MIN_PIT_COUNT )
        		gg.PitCount = gg.MIN_PIT_COUNT;

        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_OPTION_PIT_COUNT);
        	cap.SetText( "Pit Count " + gg.PitCount );          	

            break;
          //---------------------------------------------------------------------            
    	case GameGlobals.UNIQUE_ID_CHECKBOX_OPTION_SOUNDS:    		

           if( ((CheckBox)go).CheckedFlag )
        	   gg.SoundsFlag = 1;
           else
        	   gg.SoundsFlag = 0;

           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_CHECKBOX_OPTION_GARBAGE:

           if( ((CheckBox)go).CheckedFlag )
        	   gg.GarbageBlocksFlag = 1;
           else
        	   gg.GarbageBlocksFlag = 0;

           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_1:
    	       		    		
    		  
    	   Digit1 = ((MultiStateButton)go).ButtonState;
    	   Digit2 =  GameGlobals.BackGroundIndex / 10;	  
    	   
           gg.BackGroundIndex = Digit2 * 10 + Digit1;
           gg.ChangeBackGround();
           
           break;           
    	case GameGlobals.UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_2:

    	   Digit2 =  ((MultiStateButton)go).ButtonState;
    	   Digit1 = (gg.BackGroundIndex - Digit1) % 10;
    	   
           gg.BackGroundIndex = Digit2 * 10 + Digit1;
           gg.ChangeBackGround();        
  
           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_OKAY:
    		GameGlobals.ClearSaveGameData();
    		GE.DoRequest(GE.G_REQUEST_WRITE_FILE);
    		GameGlobals.SaveOptionsData();
    		GE.DoRequest(GE.G_REQUEST_WRITE_FILE);
    		GE.FileOperationFlag = 0;

    	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES_OKAY:
    		
        	CreateMenuA();
        	
           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES_LEFT:

        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_HIGH_SCORES_LIST);
        	cap.SetText( gg.SelectHighScoreBoardtoString(-1) );   

           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES_RIGHT:

        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_HIGH_SCORES_LIST);
        	cap.SetText( gg.SelectHighScoreBoardtoString(1) );         	

           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_ORIGINAL:
     	   GameGlobals.CurrentGameType = GameGlobals.GAME_TYPE_ORIGINAL;
     	   GameGlobals.ClearSomeData();
           CreateMenuF();
           break;    		
         //---------------------------------------------------------------------              
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_CHALLENGE:	
     	   GameGlobals.CurrentGameType = GameGlobals.GAME_TYPE_CHALLENGE;
     	  GameGlobals.ClearSomeData();
           CreateMenuF();
           break;   
         //---------------------------------------------------------------------              
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_TRADITIONAL: 
    	   GameGlobals.CurrentGameType = GameGlobals.GAME_TYPE_TRADITIONAL;
    	   GameGlobals.ClearSomeData();
           CreateMenuF();
           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_OKAY:
    	   GameGlobals.ClearSaveGameData();
           CreateMenuA();
           break;
         //---------------------------------------------------------------------           
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_OKAY_ADD_SCORE:
    	
    	   GameGlobals.Add2HighScore( GameGlobals.CurrentPlayerName );
    	   GameGlobals.SaveOptionsData();
           CreateMenuA();           
           break;    
         //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_LEFT:  
    	   gg.EditCurrentPlayerName( -1, 0 );
       	   cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_GAME_OVER_NAME);
           cap.SetText( gg.CurrentPlayerName );      
           cap.CursorCharPosition = gg.CurrentPlayerNameCursorPosition;
    	   break;
         //---------------------------------------------------------------------      	   
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_DOWN: 
    		gg.EditCurrentPlayerName( 0, 1 );
        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_GAME_OVER_NAME);
            cap.SetText( gg.CurrentPlayerName );     		
    	   break;
         //---------------------------------------------------------------------     	   
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_UP: 
    		gg.EditCurrentPlayerName( 0, -1 );
        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_GAME_OVER_NAME);
            cap.SetText( gg.CurrentPlayerName );     		
    	   break;
         //---------------------------------------------------------------------    	   
    	case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_RIGHT:     		
    		gg.EditCurrentPlayerName( 1, 0 );
        	cap = (Caption)FindFirstControlById(gg.UNIQUE_ID_CAPTION_GAME_OVER_NAME);
            cap.SetText( gg.CurrentPlayerName );   
            cap.CursorCharPosition = gg.CurrentPlayerNameCursorPosition;
    	   break;
         //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_RIGHT:
    		CreateMenuC2();
    		break;
         //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_LEFT:
    		CreateMenuC();
    		break;
         //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_MSB:
    		msb = (MultiStateButton)go;
    		GameGlobals.TileImageIndex_2_CellStartY_1 = msb.GetButtonState();
    	    CellSampleDisplay.RowIndex0 =  GameGlobals.TileImageIndex_2_CellStartY_1;	  
    		break;
         //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_MSB:
    		msb = (MultiStateButton)go;
    		GameGlobals.TileImageIndex_2_CellStartY_2 = msb.GetButtonState();
    		CellSampleDisplay.RowIndex1 =  GameGlobals.TileImageIndex_2_CellStartY_2; 
    		break;
         //--------------------------------------------------------------------- 
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_INTERFACE_COLORS_MSB:
    		msb = (MultiStateButton)go;
    		GameGlobals.InterfaceStyleIndex = msb.GetButtonState();
    		GameGlobals.InterfaceColors_Update_Variables();   
    		CreateMenuC2();
    		break;
         //---------------------------------------------------------------------
    	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_RANDOM_METHOD_MSB:
    		msb = (MultiStateButton)go;
    		GameGlobals.UseClassicRandomMethodFlag = msb.GetButtonState();
    		break;
         //---------------------------------------------------------------------  
    	case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA_UP:
            if( EulaCaptionBox != null )
                EulaCaptionBox.MoveIndex(-5);    		
    		break;
         //---------------------------------------------------------------------    		
    	case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA_DOWN:
            if( EulaCaptionBox != null )
                EulaCaptionBox.MoveIndex(5);      		
    		break;
         //---------------------------------------------------------------------
         //---------------------------------------------------------------------      		
        default:
           break;
    	}
    	
       }
        // *** clear mouse and key input flags for control ***       
        go.ClearDupInput();    
        
        if( go.ClassType[GameObject.TYPE_BLOCK_GAME_ENGINE] > 0 )
        {
          BlockGameEngine bge = (BlockGameEngine)go;
          
          if( bge.GameOverFlag > 0 )
          {
            ControlList[i] = null;
			GameGlobals.ClearSaveGameData();
            CreateMenuD();
          }
        }
        
        
     }
  }  
//-------------------------------------------------------------------------------------
  protected void Destroy( int UniqueId, int GroupId )
  {
    if( UniqueId > 0 )
    {
      // *** remove all objects with matching UniqueId ***
     for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
       if( ControlList[i] != null )  
         if( ControlList[i].UniqueId == UniqueId )
             ControlList[i] = null;
    }
    else
    if( GroupId > 0 )
    {
      // *** remove all objects with matching GroupId ***
     for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
       if( ControlList[i] != null )  
         if( ControlList[i].GroupId == GroupId )
             ControlList[i] = null;      
    }
    else
    if( GroupId == 0 && UniqueId == 0 )
    {
      // *** remove all objects ***
     for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
          ControlList[i] = null;      
    }
    
    EulaCaptionBox = null;
  }
//-------------------------------------------------------------------------------------
  public void Draw()
  {
    if( ItsMenuCursorParallelia != null )
        ItsMenuCursorParallelia.Draw();
    
    for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
      if( ControlList[i] != null )  
          ControlList[i].Draw();
/*
    String str;
    str = new String(GameGlobals.dummystr + "\n\n " + GameControl.ScreenWidth + ", " 
  	+ GameControl.ScreenHeight );
*/  	
   
    //gg.debugcaption.SetText(gg.dummystr);	       
    //GameGlobals.debugcaption.Draw();
   
    GameGlobals.BackDrop.Draw();    
    
   if( DoneLoadingFlag == 0  ) 
    if( GameControl.CheckDoneLoading() > 0 )
    { 	
    	Init();
        DoneLoadingFlag = 1;
    }    
  }  
//-------------------------------------------------------------------------------------
  // *** call it during screen onDraw ***
  public void Do()
  {
	if( ItsMenuCursorParallelia != null )
		ItsMenuCursorParallelia.Do();
	
    CheckControlListState();
    
    for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
      if( ControlList[i] != null )
          ControlList[i].Do();
  }
//-------------------------------------------------------------------------------------
  // *** tries to current game state ***
  public boolean SaveGameData()
  {	  
	  boolean SuccessFlag = false;
	  
	    for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
	      if( ControlList[i] != null )
	       if( ControlList[i].ClassType[GameObject.TYPE_BLOCK_GAME_ENGINE] > 0)
	       {
	         BlockGameEngine bge = (BlockGameEngine)ControlList[i];
	         bge.SaveGameData();
	         SuccessFlag = true;
	         break;
	       }
	    
	  return SuccessFlag;
  }
//------------------------------------------------------------------------------------- 
  public void SetGameObjectImages0()
  {	  
	 int i;
	 for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
		  if( ControlList[i] != null )
		      SetGameObjectUniqueImage( ControlList[i]);	  
  }
//-------------------------------------------------------------------------------------  
  public static void SetGameObjectUniqueImage( GameObject go )
  {
   Button but;
   Caption cap;
   CheckBox chk;
   RadioButton rad;
   MultiStateButton msb;
   SimpleBackGround sbg;
   BlockGameEngine bge;   
   int ImageIndex, ImageIndex2, FontColor, nTileCellStartY_1, nTileCellStartY_2, UseClassicRandomMethodFlag;
   int InterfaceStyleIndex, Digit1, Digit2;

   ImageIndex = GameGlobals.TileImageIndex_1;
   FontColor = GameGlobals.MainFontColor;
   ImageIndex2 = GameGlobals.TileImageIndex_2;
   nTileCellStartY_1 = GameGlobals.TileImageIndex_2_CellStartY_1;
   nTileCellStartY_2 = GameGlobals.TileImageIndex_2_CellStartY_2;
   UseClassicRandomMethodFlag = GameGlobals.UseClassicRandomMethodFlag;
   InterfaceStyleIndex = GameGlobals.InterfaceStyleIndex;
				   
   //*** for the multistate buttons ***
   int[] listx = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
   int[] listy = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		
   switch( go.UniqueId )
   {
  	case GameGlobals.UNIQUE_ID_BUTTON_START:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,4,  0,4,  4,1, 48,48, 255);
        break;
  	case GameGlobals.UNIQUE_ID_BUTTON_OPTIONS:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,5,  0,5,  4,1, 48,48, 255);
        break;    
  	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,6,  0,6,  4,1, 48,48, 255);
        break;
  	case GameGlobals.UNIQUE_ID_BUTTON_ABOUT:
  	case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,8,  0,8,  4,1, 48,48, 255);
        break;
        
  	case GameGlobals.UNIQUE_ID_BUTTON_GAME_ORIGINAL:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 4,4,  4,4,  4,1, 48,48, 255);
        break;    
  	case GameGlobals.UNIQUE_ID_BUTTON_GAME_CHALLENGE:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 4,5,  4,5,  4,1, 48,48, 255);
        break;       
  	case GameGlobals.UNIQUE_ID_BUTTON_GAME_TRADITIONAL:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 4,6,  4,6,  4,1, 48,48, 255);
        break;    

  	case GameGlobals.UNIQUE_ID_CAPTION_OPTION_SPEED:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );  		
        break;
  	case GameGlobals.UNIQUE_ID_CAPTION_OPTION_PIT_COUNT:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );  		
        break;
        
  	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_INC_SPEED:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 6,3,  6,3,  1,1, 48,48, 255);
        break;   		
  	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_DEC_SPEED:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 7,3,  7,3,  1,1, 48,48, 255);
        break;   		
  	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_INC_PIT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 6,3,  6,3,  1,1, 48,48, 255);
        break;   	  		
  	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_DEC_PIT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 7,3,  7,3,  1,1, 48,48, 255);
        break;  		
  	case GameGlobals.UNIQUE_ID_CHECKBOX_OPTION_SOUNDS:
  		chk = (CheckBox)go;
  		chk.SetTileStyle( ImageIndex, ImageIndex,  8,3,  9,3,  1,1, 48,48, 255);
  		break;
  	case GameGlobals.UNIQUE_ID_CHECKBOX_OPTION_GARBAGE:
  		chk = (CheckBox)go;
  		chk.SetTileStyle( ImageIndex, ImageIndex,  8,3,  9,3,  1,1, 48,48, 255);
  		break;  		
  	case GameGlobals.UNIQUE_ID_BUTTON_OPTION_OKAY:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,7,  0,7,  2,1, 48,48, 255);
        break;  		
  	case GameGlobals.UNIQUE_ID_CAPTION_HIGH_SCORES_LIST:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );   		
        break;
  	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES_OKAY:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,7,  0,7,  2,1, 48,48, 255);
        break;    		
  	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES_LEFT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 2,3,  2,3,  1,1, 48,48, 255);
        break;    	  		
  	case GameGlobals.UNIQUE_ID_BUTTON_HIGH_SCORES_RIGHT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 3,3,  3,3,  1,1, 48,48, 255);
        break;      		
    case GameGlobals.UNIQUE_ID_CAPTION_GAME_OVER_NAME:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );     	
        break;
  	case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_LEFT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 2,3,  2,3,  1,1, 48,48, 255);
        break;    		
    case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_DOWN:
    case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA_DOWN:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,3,  0,3,  1,1, 48,48, 255);
        break;        	
    case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_UP:
    case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA_UP:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 1,3,  1,3,  1,1, 48,48, 255);
        break;    
    case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_RIGHT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 3,3,  3,3,  1,1, 48,48, 255);
        break;        	        
    case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_OKAY:    	
    case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_OKAY:
    case GameGlobals.UNIQUE_ID_BUTTON_ABOUT_EULA_OKAY:	
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,7,  0,7,  2,1, 48,48, 255);
        break;      	
    case GameGlobals.UNIQUE_ID_BUTTON_GAME_OVER_OKAY_ADD_SCORE:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,7,  0,7,  2,1, 48,48, 255);
        break;
    case BlockGameEngine.PlayerControls.UNIQUE_ID_BUTTON_ROTATE_LEFT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 4,3,  4,3,  1,1, 48,48, 255);    	
        break;
    case BlockGameEngine.PlayerControls.UNIQUE_ID_BUTTON_ROTATE_RIGHT:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 5,3,  5,3,  1,1, 48,48, 255);    	
    	break;
    case BlockGameEngine.PlayerControls.UNIQUE_ID_BUTTON_LEFT:    
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_LEFT:	    	
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 2,3,  2,3,  1,1, 48,48, 255);    	
    	break;
    case BlockGameEngine.PlayerControls.UNIQUE_ID_BUTTON_RIGHT:
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_RIGHT:	
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 3,3,  3,3,  1,1, 48,48, 255);    	
    	break;
    case BlockGameEngine.PlayerControls.UNIQUE_ID_BUTTON_DROP:
        but = (Button)go;
        but.SetTileStyle( ImageIndex, ImageIndex, 0,3,  0,3,  1,1, 48,48, 255);    	
    	break;
    case BlockGameEngine.PlayerControls.UNIQUE_ID_BUTTON_SWITCH_LAYER:     
  		
  		msb = (MultiStateButton)go;
  		msb.SetTileStyle( ImageIndex, listx, listy, 1,1, 48,48, 255 );      	
    	break;
    case GameGlobals.UNIQUE_ID_CAPTION_MAIN_TITLE:
    	cap = (Caption)go;
    	
    	cap.SetTileStyle( ImageIndex,  0,0,  6,2,  48,48, 255 );
    	break;
    case GameGlobals.UNIQUE_ID_CAPTION_GENERAL:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );
    	break;
    case GameGlobals.UNIQUE_ID_BLOCK_GAME_ENGINE_1:
    	bge = (BlockGameEngine)go;
    	bge.SetOptions( ImageIndex2, nTileCellStartY_1, nTileCellStartY_2 );
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_MSB:
  		
  		msb = (MultiStateButton)go;
  		msb.SetTileStyle( ImageIndex, listx, listy, 1,1, 48,48, 255 );      
  		msb.SetButtonState( nTileCellStartY_1 );
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_0:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );    	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_1:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  0,nTileCellStartY_1,  1,1,  20,20,  255 );
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_2:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  1,nTileCellStartY_1,  1,1,  20,20,  255 );    	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_3:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  2,nTileCellStartY_1,  1,1,  20,20,  255 );    	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_A_CAP_4:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  3,nTileCellStartY_1,  1,1,  20,20,  255 );    	
        break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_MSB:
  		msb = (MultiStateButton)go;
  		msb.SetTileStyle( ImageIndex, listx, listy, 1,1, 48,48, 255 );
  		msb.SetButtonState( nTileCellStartY_2 );
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_0:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );    	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_1:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  4,nTileCellStartY_2,  1,1,  20,20,  255 );      	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_2:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  5,nTileCellStartY_2,  1,1,  20,20,  255 );     	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_3:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  6,nTileCellStartY_2,  1,1,  20,20,  255 );     	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_4:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  7,nTileCellStartY_2,  1,1,  20,20,  255 );     	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_5:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  8,nTileCellStartY_2,  1,1,  20,20,  255 );     	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_6:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  9,nTileCellStartY_2,  1,1,  20,20,  255 );     	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_7:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  10,nTileCellStartY_2,  1,1,  20,20,  255 );     	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_GROUP_COLORS_B_CAP_8:
    	cap = (Caption)go;
    	cap.SetText("");
    	cap.SetTileStyle( ImageIndex2,  11,nTileCellStartY_2,  1,1,  20,20,  255 );     	
        break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_INTERFACE_COLORS_MSB:
  		msb = (MultiStateButton)go;
  		msb.SetTileStyle( ImageIndex, listx, listy, 1,1, 48,48, 255 );    	
  		msb.SetButtonState( InterfaceStyleIndex );
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_INTERFACE_COLORS_CAP_0:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );    	
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_RANDOM_METHOD_MSB:    	
  		msb = (MultiStateButton)go;
  		msb.SetTileStyle( ImageIndex, listx, listy, 1,1, 48,48, 255 );    	
  		msb.SetButtonState( UseClassicRandomMethodFlag );
    	break;
    case GameGlobals.UNIQUE_ID_BUTTON_OPTION_RANDOM_METHOD_CAP_0:
    	cap = (Caption)go;
    	cap.SetFontColor( FontColor );    
    	
    	if( UseClassicRandomMethodFlag > 0 )
    	  cap.SetText("Random Method:\nClassic");
    	else
    	  cap.SetText("Random Method:\nBag");
    	break;
  	
    case GameGlobals.UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_1:    	

        Digit1 = GameGlobals.BackGroundIndex % 10;
    	Digit2 = GameGlobals.BackGroundIndex / 10;    	
    	msb = (MultiStateButton)go;
    	msb.SetButtonState( Digit1 );
    	msb.SetTileStyle( ImageIndex, listx, listy, 1,1, 48,48, 255 );   
   	
    	break;
    case GameGlobals.UNIQUE_ID_MULTISTATE_BUTTON_OPTION_BACKGROUND_2:	

        Digit1 = GameGlobals.BackGroundIndex % 10;
    	Digit2 = GameGlobals.BackGroundIndex / 10;    	
    	msb = (MultiStateButton)go;
    	msb.SetButtonState( Digit2 );
    	msb.SetTileStyle( ImageIndex, listx, listy, 1,1, 48,48, 255 );  
 	
    	break;    
    default:
        break;
   }
  
  }
//-------------------------------------------------------------------------------------
public int DoBackKey()
{
	int exitflag = 0;
	
    for( i = 0; i < CONTROL_LIST_LENGTH; i++ )
      if( ControlList[i] != null )  
      {
    	 switch( ControlList[i].GroupId )
    	 {
    	   case GameGlobals.GROUP_ID_MENU_A:
    		 exitflag = 1;
    		 break;
    	   case GameGlobals.GROUP_ID_MENU_B:
    	   case GameGlobals.GROUP_ID_MENU_C:    		   
    	   case GameGlobals.GROUP_ID_MENU_C2:
    	   case GameGlobals.GROUP_ID_MENU_D:
    	   case GameGlobals.GROUP_ID_MENU_E:
    	   case GameGlobals.GROUP_ID_MENU_F:
    	   case GameGlobals.GROUP_ID_MENU_G:
    	   case GameGlobals.GROUP_ID_MENU_H:
             CreateMenuA();	
             break;
           default:
        	exitflag = 1;
        	break;
    	 }
    	 break;
      }
  
    return exitflag;
}
//-------------------------------------------------------------------------------------  
}
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
