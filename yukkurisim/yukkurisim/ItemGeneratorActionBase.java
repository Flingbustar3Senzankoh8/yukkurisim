package yukkurisim;

import gamestatus.GameTimer;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

/**
 * �_�ƁE�~�j�Q�[���E���ȂǁA�m���I�ɃA�C�e������ɓ��艽�炩�̑㏞�𕉂�
 * �s���̃x�[�X�N���X
 * @author �|�`�G��
 *
 */
public abstract class ItemGeneratorActionBase {
	protected int levelIndexMax;	// ���͉\�ȃ��x���͈́i���j�[�N�e�[�u���������p�ӂ���Ă��邩�H�j
	protected int MaxIndex;		// ���͉\�ȃC���f�b�N�X�̍ő�l

	// �e�[�u���̌^�͓��� Hashmap<Index�i���o,�A�C�e���i���o>
	protected HashMap<Integer,Integer> DefaultTable;				// �f�t�H���g�e�[�u��
	protected Vector< HashMap<Integer,Integer> > UniqueTable;	// ���j�[�N�e�[�u���̃x�N�^
	protected yukkurisim_main owner;
	/**
	 * �R���X�g���N�^
	 *
	 */
	public ItemGeneratorActionBase(yukkurisim_main own){
		owner = own;
		Initialize();
	}
	
	/**
	 * ���������\�b�h
	 *
	 */
	public void Initialize()
	{
		InitDefaultItemTable();
		InitUniqueItemTable();
	}
	
	/**
	 * �A�C�e���e�[�u���̃f�B�t�H���g�G���A�i�X�e�[�^�X�ɂ���ăe�[�u�����ϓ����Ȃ��G���A�j
	 * ������������B
	 * ���̊֐����q�N���X�ŃI�[�o�[���C�h����邱�ƂŁA�s�����Ƃ̃f�B�t���g�e�[�u����
	 * ��`����B
	 *
	 */
	public abstract void InitDefaultItemTable();
	
	/**
	 * �A�C�e���e�[�u���̃��j�[�N�G���A�i�X�e�[�^�X�ɂ���ăe�[�u�����ϓ�����G���A�j
	 * ������������B
	 * ���̊֐����q�N���X�ŃI�[�o�[���C�h����邱�ƂŁA�s�����Ƃ̃��j�[�N�e�[�u����
	 * ��`����B
	 *
	 */
	public abstract void InitUniqueItemTable();
	
	/**
	 * �\�͒l�ɉ����ēK�؂ȃ��j�[�N�e�[�u�����Z�o����B
	 * 
	 * @param status
	 * @return
	 */
	public abstract int getIndexLevel(int status);
	
	/**
	 * �A�C�e���擾�ɒ��킷��
	 * �ȉ��̎菇�ŏ������炱�̃R�����g����������
	 * �@y�̃X�e�[�^�X����getIndexLevel�ŃC���f�b�N�X�擾
	 * �A�m�����s
	 * �BItemManager�ɃA�N�Z�X���A�A�C�e���̑�������
	 * �C�A�i�E���X
	 * @param y
	 */
	public void getItemChallenge(yukkuri_base y)
	{
		int UniqueIndex = getIndexLevel(y.Get_Cooperative());
		HashMap<Integer,Integer> UniqueTmp = this.UniqueTable.get(UniqueIndex);
		int MaxTableSize = DefaultTable.size() + UniqueTmp.size();	// �f�t�H���g�e�[�u���̃T�C�Y+�I�΂ꂽ���j�[�N�e�[�u���̃T�C�Y
		Random sai = new Random();
		int ChallengeIndex = sai.nextInt(MaxTableSize);
		
		if(ChallengeIndex>=DefaultTable.size())
		{	// ���j�[�N�e�[�u���G���A��������
			ChallengeIndex -= DefaultTable.size();
			if(UniqueTmp.containsKey(ChallengeIndex))
			{
				int itemNum = UniqueTmp.get(ChallengeIndex);
				if(itemNum!=0)
				{	// �����ŃA�C�e���擾�m��
					ItemManager iman = ItemManager.Get_Instance(owner);
					iman.setItemIncrement(itemNum);
					Widget_Manager.Get_Instance(owner).Popup_Dialog_Window(iman.getItemName(itemNum)+"�����n���܂����I");
					System.out.println("�A�C�e���l����"+itemNum);
				}
			}
			else
			{
				// �����Ƃ��Ă͉������Ȃ��B
			}
		}
		else
		{	// �f�B�t�H���g�e�[�u���G���A������
			if(DefaultTable.containsKey(ChallengeIndex))
			{
				int itemNum = DefaultTable.get(ChallengeIndex);
				if(itemNum!=0)
				{	// �����ŃA�C�e���擾�m��
					ItemManager iman = ItemManager.Get_Instance(owner);
					iman.setItemIncrement(itemNum);
					Widget_Manager.Get_Instance(owner).Popup_Dialog_Window(iman.getItemName(itemNum)+"�����n���܂����I");
					System.out.println("�A�C�e���l����"+itemNum);
				}
			}
			else
			{
				// �����Ƃ��Ă͉������Ȃ��B
			}
			
		}
		getRisk(y);	// ���n�̐��ۂɊ֌W�Ȃ����X�N�͑��݂���
		System.out.println("item����^�C�}���쁨"+GameTimer.Get_Instance(owner, 0).Get_Times());

	}
	
	/**
	 * ���X�N���擾����B�igetItemChallenge����R�[�����Ă��ǂ��j
	 * @param y
	 */
	public abstract void getRisk(yukkuri_base y);
}
