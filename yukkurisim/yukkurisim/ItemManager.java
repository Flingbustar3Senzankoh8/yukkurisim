package yukkurisim;

import gamestatus.Const_Value;
import gamestatus.SaveData;
import yukkurisim.yukkurisim_main;
import java.io.*;
/**
 * �A�C�e�����̂��̂��Ǘ�����N���X�B
 * �i�A�C�e���֘A�̃C���^�[�t�F�[�X�Ƃ��Ă͗p���Ȃ��j
 * @author pochiel
 *
 */
public class ItemManager implements Serializable {
	private int[] ItemCount;			// index�Ԃ̃A�C�e�������������Ă��邩
	private boolean[] ItemKnowledge;		// index�Ԃ̃A�C�e�������ɒm���Ă��邩
	
	/**
	 * �A�C�e���ԍ��̃A�C�e�������m����Ԃ��B
	 * @param i
	 * @return
	 */
	public boolean isKnown(int i)
	{
		return this.ItemKnowledge[i];
	}
	
	/**
	 * �A�C�e���ԍ��ɂ��Ă̊��m�����X�V����B
	 * @param i
	 * @param t
	 */
	public void setKnowledge(int i,boolean t)
	{
		this.ItemKnowledge[i]=t;
	}
	
	private  Const_Value �萔 = new Const_Value();
	
	private static ItemManager myself;
	private yukkurisim_main owner;
	
	public void Initialize()
	{
		ItemCount = new int[�萔.�A�C�e���ő�ԍ�+1];
		ItemKnowledge = new boolean[�萔.�A�C�e���ő�ԍ�+1];
		
		for(int i=0;i<�萔.�A�C�e���ő�ԍ�+1;i++)
		{
			ItemCount[i]=0;
			ItemKnowledge[i]=false;
		}
	}
	
	/**
	 * �R���X�g���N�^
	 * @param own
	 */
	public ItemManager(yukkurisim_main own)
	{
		owner = own;
		Initialize();
	}

	/******* �C���X�^���X�𓾂�(�e�C���X�^���X�ƈ�������) ********/
	public static synchronized ItemManager Get_Instance( yukkurisim_main own )
	{
		if( myself == null)
		{
			myself = new ItemManager(own);
		}

		return myself;
	}

	/**
	 * �A�C�e�����g�p����B
	 * @param itemnum
	 */
	public void UseItem(int itemnum)
	{
		if(this.isKnown(itemnum))
		{	// �m���Ă�
			if(this.getItemCount(itemnum)>0)
			{ // ���A�����Ă�
				if(itemnum==�萔.�A�C�e��_���ق�)
				{
					System.out.println("�A�C�e���g�p�F���ق�");
				}
				else if(itemnum==�萔.�A�C�e��_����݂傤����)
				{
					System.out.println("�A�C�e���g�p�F����݂傤����");
					
				}
				else if(itemnum==�萔.�A�C�e��_�ق���)
				{
					System.out.println("�A�C�e���g�p�F�ق���");
					
				}
				else if(itemnum==�萔.�A�C�e��_�������t�[�h)
				{
					System.out.println("�A�C�e���g�p�F�������t�[�h");
					
				}
				else if(itemnum==�萔.�A�C�e��_��݂��Ԃ���)
				{
					System.out.println("�A�C�e���g�p�F��݂��Ԃ���");
					
				}
				else if(itemnum==�萔.�A�C�e��_�I�����W�W���[�X)
				{
					System.out.println("�A�C�e���g�p�F�I�����W�W���[�X");
					
				}
				else if(itemnum==�萔.�A�C�e��_�V���[�N���[��)
				{
					System.out.println("�A�C�e���g�p�F�V���[�N���[��");
					
				}
				else if(itemnum==�萔.�A�C�e��_�n�T�~)
				{
					System.out.println("�A�C�e���g�p�F�n�T�~");
					
				}
				else if(itemnum==�萔.�A�C�e��_�u���V)
				{
					System.out.println("�A�C�e���g�p�F�u���V");
					
				}
				else if(itemnum==�萔.�A�C�e��_�|���E�f�E�����)
				{
					System.out.println("�A�C�e���g�p�F�|���ł����");
					
				}
				else if(itemnum==�萔.�A�C�e��_������)
				{
					System.out.println("�A�C�e���g�p�F������");
					
				}
				else if(itemnum==�萔.�A�C�e��_�ԉ�)
				{
					System.out.println("�A�C�e���g�p�F�ԉ�");
					
				}
				else if(itemnum==�萔.�A�C�e��_�v�΂̂�����)
				{
					System.out.println("�A�C�e���g�p�F���Ȃ߂����̂�����");
					
				}
			}
		}
	}

	/**
	 * num�Ԃ̃A�C�e�����������Ă��邩�Ԃ��B
	 * @param num
	 * @return
	 */
	public int getItemCount(int num) {
		return ItemCount[num];
	}

	/**
	 * itemnum�Ԃ̃A�C�e���̌����Z�b�g����B
	 * @param itemnum
	 * @param cnt
	 */
	public void setItemCount(int itemnum,int cnt) {
		ItemCount[itemnum] = cnt;
		if(ItemCount[itemnum]>0)
		{
			if(!(this.isKnown(itemnum)))
			{
				this.setKnowledge(itemnum, true);
			}
		}
	}
	
	/**
	 * itemnum�Ԃ̃A�C�e���̌�������₷
	 * @param itemnum
	 */
	public void setItemIncrement(int itemnum)
	{
		setItemCount(itemnum,getItemCount(itemnum)+1);
	}
	
	/**
	 * i�Ԃ̃A�C�e���̖��O��Ԃ��B
	 * @param i
	 * @return
	 */
	public String getItemName(int i)
	{
		String  outmessage[] ={"������",
				"�������t�[�h",
				"�|���E�f�E�����",
				"�V���[�N���[��",
				"�I�����W�W���[�X",
				"�ԉ�",
				"���ق�",
				"����݂傤����",
				"�ق���",
				"�͂���",
				"�u���V",
				"��݂��Ԃ���",
				"�v�΂̂�����"};
		return outmessage[i-1];
	}

	/**
	 * i�Ԃ̃A�C�e���Ɋւ��������Ԃ��B
	 * @param i
	 * @return
	 */
	public String getItemExplanation(int i)
	{
		String  outmessage[] ={"���ʂ̎����B�G�����͉h�{������B",
				"���C�͂Ȃ����h�{�̓o�b�`���B",
				"�^�L�����َq�̃p�`���m�B",
				"���َq�X�ō��ꂽ�኱�����߂̂��́B",
				"�Ȃ����͒m��Ȃ���������Ƃ������̏����ӂ�����B",
				"�X�y���J�[�h���������ł���ƕ]���̃J�[�h�^�ԉ΁B���܂ɉ��������B",
				"�����Ȃ��ƈꕔ�̂������ɑ�l�C�B���܂ɘ����ɂȂ�B",
				"������S���{�[���B�A�z�̖͗l���B���܂ɉ��������B",
				"�|���p��B���܂ɉ��������B",
				"�������̏���̈ꕔ��j�󂵁A�����߂�U���ł���B�����ڂ͓��ɕς��Ȃ����c�B",
				"�I�񂾂������̔��������Ă�邱�Ƃ��o����B",
				"�ʂɂ�݂�Ⴊ�����Ă���킯�ł͂Ȃ����A��݂��̐����Đ�����B�ߐH��ɂ͖����B",
				"�n�k���N�����Ă������S���̗̑͂����炷�B"};
		return outmessage[i-1];
	}
	
	/**
	 * getSaveData�͔z��Ƃ��Ă����؂�Ƀf�[�^�𑗂邪
	 * setSaveData�͈����M����B
	 * @return
	 */
	public SaveData[] getSaveData()
	{
		SaveData mysave[] = new SaveData[�萔.�A�C�e���ő�ԍ�];
		for(int i=0;i<�萔.�A�C�e���ő�ԍ�;i++)
		{
			SaveData tmp = new SaveData();
			tmp.itemflag = true;
			tmp.itemindex = i+1;
			tmp.itemcount = getItemCount(i+1);
			tmp.ItemKnowledge = isKnown(i+1);
			mysave[i] = tmp;
		}
		return mysave;
	}
	
	public void setSaveData(SaveData mysave)
	{
		int i = mysave.itemindex;
		this.setItemCount(i, mysave.itemcount);
		this.setKnowledge(i, mysave.ItemKnowledge);
	}
}
