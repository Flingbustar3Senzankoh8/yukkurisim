package gamestatus;

public class GameInfoManager {
	protected  Const_Value �萔 = new Const_Value();
	private static GameInfoManager myself;
	private int myCash;
	
	
	/******* �C���X�^���X�𓾂� ********/
	public static synchronized GameInfoManager Get_Instance( )
	{
		if( myself == null)
		{
			myself = new GameInfoManager();
		}

		return myself;
	}
	
	public GameInfoManager()
	{
		myCash = �萔.�����������l;
		PlayPartState = new int[�萔.TYPE_�L�����N�^�[�n�^�C�v����];
		for(int i=0;i<�萔.TYPE_�L�����N�^�[�n�^�C�v����;i++)
		{
			PlayPartState[i]=0;
		}
	}
	
	/**
	 * ��������Ԃ�
	 * @return
	 */
	public int GetCash()
	{
		return myCash;
	}
	
	/*
	 * ���������Z�b�g����
	 */
	public void SetCash(int c)
	{
		myCash = c;
	}

	/**
	 * �I�u�W�F�N�g�ݒu�ɕK�v�ȋ��z��Ԃ��B
	 * @return
	 */
	public int getCost(int objtype)
	{
		if(objtype==�萔.TYPE_��object)
		{
			return 200;
		}
		else if(objtype==�萔.TYPE_��object)
		{
			return 400;
		}
		else if(objtype==�萔.TYPE_�_�nobject)
		{
			return 300;
		}
		return 0;
	}
	
	private int[] PlayPartState;

	/**
	 * �푰���Ƃ̍s���w�茋�ʂ�getter
	 * @return
	 */
	public int getPlayPartState(int i) {
		return PlayPartState[i];
	}
	
	/**
	 * �푰���Ƃ̍s���w�茋�ʂ�setter
	 * @param playPartState
	 */
	public void setPlayPartState(int syuzoku,int playPartState) {
		PlayPartState[syuzoku] = playPartState;
	}
}
