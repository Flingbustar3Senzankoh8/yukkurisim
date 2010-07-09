package game_scene;

import java.awt.Graphics2D;

import yukkurisim.ImageLoader;
import yukkurisim.yukkurisim_main;

public class Loading extends Scene_Base {

	/*
	 * �q�[�v��̃f�[�^�ɃA�N�Z�X����ۂ́A����1�̒��ӓ_��
	 * �X���b�h����q�[�v�ւ̃A�N�Z�X���ɂ́A�L���b�V�������p�����Ƃ����_�ł��B
	 * �S�ẴX���b�h�̓L���b�V���̈�Ƃ������̂�����
	 * �q�[�v�̃f�[�^���Q�Ƃ���ۂ�A�q�[�v�̃f�[�^���X�V����ۂ̑S�Ă̑���ɂ����āA�L���b�V�����g���܂��B
	 * �܂�A�q�[�v��̃f�[�^���Q�Ƃ��Ă��A�L���b�V����̌Â��f�[�^���Q�Ƃ��Ă���\��������A
	 * �q�[�v��̃f�[�^���X�V���Ă��A�L���b�V����̃f�[�^���X�V���Ă��邾����
	 * �ʂ̃X���b�h����́A�X�V�O�̌Â��f�[�^�������Ă���\��������܂��B
	 * ���̃L���b�V���́A����^�C�~���O�Ńq�[�v�Ɠ������Ƃ�
	 * �ŐV�̏�ԂɂȂ�܂����A���̃^�C�~���O��m�邱�Ƃ͂ł��܂���B 
	 */
	
	private int LoadExitedScene;
	private boolean nowLoading;
	private boolean nowFading;
	
	private ImageLoader iLoadertmp;
	
	/** ���[�f�B���O���ɕ\������N���X **/
	public Loading(yukkurisim_main own) {
		super(own);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}
	
	public void render(Graphics2D g)
	{
		super.render(g);
		//System.out.println("Now loading....");
	}
	
	public void initResources() 
	{
		super.initResources();
		LoadExitedScene = -1;
		nowLoading = false;
		nowFading = false;
	}
	
	public void update(long elapsedTime)
	{
		super.update(elapsedTime);
		if( !nowLoading )
		{	
			if( !nowFading )
			{	// �܂����[�h�n�܂��ĂȂ���
				if( LoadExitedScene == �萔.SCENE_GAME01 )
				{
					iLoadertmp = ImageLoader.Get_Instance(owner);
					iLoadertmp.start();		// ���[�h�J�n
					nowLoading = true;
				}
				if ( LoadExitedScene == �萔.SCENE_LOAD )
				{
					iLoadertmp = ImageLoader.Get_Instance(owner);				
					iLoadertmp.start();		// ���[�h�J�n
					nowLoading = true;
				}
			}
		}
		else
		{ 	// ���łɃ��[�f�B���O�X���b�h�������Ă邨
			if( !iLoadertmp.isAlive() )
			{	//�X���b�h�������I��������
				owner.setImageLoader( iLoadertmp );
				nowLoading = false;
				nowFading = true;
				this.FadeOutToScene( LoadExitedScene );
			}
		}
	}
		
	/**
	 * ���[�f�B���O�����I�����΂��V�[���i���o���Z�b�g����
	 * @param sceneno
	 */
	public void setNextSceneNo( int sceneno )
	{
		LoadExitedScene = sceneno;
	}
	
	/**
	 * �I������
	 */
	public void DestractFadeOut()
	{
		nowFading = false;
		LoadExitedScene = -1;
	}
}
