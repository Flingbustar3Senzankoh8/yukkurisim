package yukkurisim;

import gamestatus.Const_Value;

/**
 * 素材以外でローディングシーンマルチスレッド実行を行いたい場合
 * ココに書く
 * @author ポチエル
 *
 */
public class OtherLoader extends Thread {
	private yukkurisim_main owner;					//オーナーGameインスタンスへの参照
	private  Const_Value 定数 = new Const_Value();
	private volatile static OtherLoader myself;

	private int LogicFlag;		// どの処理を行うかを決定するフラグ
	/**
	 * コンストラクタ
	 * @param own
	 */
	public OtherLoader(yukkurisim_main own)
	{
		owner = own;
		LogicFlag = 0;
	}
	
	public void run() {
		if(LogicFlag==0)
		{
			// setLogicFlagを経由していなければ何もしない
		}
		else if(LogicFlag==定数.ローディング_ロジック1)
		{
	    	MapObject_Manager OnMapObj = new MapObject_Manager(owner,"YUKKURI_REIMU");
			Physical_Law_Facade phfacade = Physical_Law_Facade.Get_Instance(owner);
			ItemManager itemman = ItemManager.Get_Instance(owner);
			
	    	/********** マップの宣言 ***********************/
	    	int[][] mapgrid = {
	    			{0,0,0,0,0,0,1,0,0,0,0,0,0},
	    			{0,0,0,0,0,1,1,0,0,0,0,0,0},
	    			{0,0,0,0,0,1,1,1,0,0,0,0,0},
	    			{0,0,0,0,1,1,1,1,0,0,0,0,0},
	    			{0,0,0,0,1,1,1,1,1,0,0,0,0},
	    			{0,0,0,1,1,1,1,1,1,0,0,0,0},
	    			{0,0,0,1,1,1,1,1,1,1,0,0,0},
	    			{0,0,3,1,1,1,1,1,1,1,0,0,0},
	    			{0,0,3,1,1,1,1,1,1,1,1,0,0},
	    			{0,1,4,3,1,1,1,1,1,1,1,0,0},
	    			{0,1,4,3,1,1,1,1,1,1,1,1,0},
	    			{1,1,1,4,3,1,1,1,1,1,1,1,0},
	    			{1,1,1,4,3,1,1,1,1,1,1,1,1},
	    			{1,1,1,1,4,3,1,1,1,1,1,1,1},
	    			{0,1,1,1,4,3,1,1,1,1,1,1,1},
	    			{0,1,1,1,1,1,1,1,1,1,1,1,0},
	    			{0,0,1,1,1,1,1,1,1,1,1,1,0},
	    			{0,0,1,1,1,1,1,1,1,1,1,0,0},
	    			{0,0,0,1,1,1,1,1,1,1,1,0,0},
	    			{0,0,0,1,1,1,1,1,1,1,0,0,0},
	    			{0,0,0,0,1,1,1,1,1,1,0,0,0},
	    			{0,0,0,0,1,1,1,1,1,0,0,0,0},
	    			{0,0,0,0,0,1,1,1,1,0,0,0,0},
	    			{0,0,0,0,0,1,1,1,0,0,0,0,0},
	    			{0,0,0,0,0,0,1,1,0,0,0,0,0},
	    			{0,0,0,0,0,0,1,0,0,0,0,0,0},

	    	};
	  
	    	// maptilemanagerとmapobjectmanagerを作成し、物理法則クラスへ登録する
	    	MapTileManager MapMan = new MapTileManager(owner , mapgrid);		//マップマネージャでマップを作成する。

			phfacade.Set_Manager(MapMan, OnMapObj, itemman);

			Widget_Manager.Get_Instance(owner);	// ロード処理
	    	
	    	Cursor_Manager.Get_Instance(owner);		// ロードだけでよい
		}
	}
	
	public void setLogicFlag(int s)
	{
		LogicFlag = s;
	}


}
