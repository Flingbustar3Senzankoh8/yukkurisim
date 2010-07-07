package yukkurisim;

import java.io.*;
import java.util.Vector;
import gamestatus.Const_Value;
import gamestatus.SaveData;
import com.golden.gamedev.object.*;

public class GameSaveLoader {
	private Const_Value �萔 = new Const_Value();
	
    private FileOutputStream outFile;
    private ObjectOutputStream outObject;
    private Vector<SaveData> mysavedata = new Vector<SaveData>();

    /** 
     * �Z�[�u�f�[�^�C���X�^���X�̍쐬
     *
     */
    public void makeSaveData(yukkurisim_main owner)
    {
    	/** �I���}�b�v�I�u�W�F�N�g�̃p�b�L���O **/
    	{
	    	MapObject_Manager mapman = Physical_Law_Facade.Get_Instance(owner).Get_ObjectManager();
			Sprite[] tmpsprites = mapman.getSprites();
			int size = mapman.getSize();
			
			for(int i=0;i<size;i++)
			{
				Object_base tmp = (Object_base)tmpsprites[i];
				if(tmp.isActive())
				{
					if(tmp.Get_Type()==�萔.TYPE_�������object)
					{
						mysavedata.add(((yukkuri_base)tmp).getSaveData());
					}
					else if(tmp.Get_Type()==�萔.TYPE_��object)
					{
						mysavedata.add(((Tree_Object)tmp).getSaveData());
					}
					else if(tmp.Get_Type()==�萔.TYPE_��object)
					{
						if(((House_Object)tmp).isParent)
						{
							mysavedata.add(((House_Object)tmp).getSaveData());
							// �e�I�u�W�F�N�g�̂݃Z�[�u����
						}
					}
					tmp = (Object_base) mapman.getActiveSprite();
				}
			}
    	}
    	/** �A�C�e���f�[�^�̃p�b�L���O **/
    	{
    		ItemManager itemman = ItemManager.Get_Instance(owner);
    		for(int i =0;i<�萔.�A�C�e���ő�ԍ�;i++)
    		{
    			SaveData[] tmp = itemman.getSaveData();
    			mysavedata.add(tmp[i]);
    		}
    	}    	
    }
    
    /** �R���X�g���N�^ **/
    public GameSaveLoader()
	{
	}
		
	public void SaveState(yukkurisim_main owner)
	{
		try
		{
			makeSaveData(owner);	// �Z�[�u�f�[�^�C���X�^���X�̍쐬
			outFile = new FileOutputStream("iurtilt.dat");	// �������ďo�Ă����P������Ƀt�@�C��������
			outObject = new ObjectOutputStream(outFile);
			outObject.writeObject(mysavedata);
			outObject.reset();
			outObject.close();
			outFile.close();
		}
		catch (IOException e) {
			// ��O�����͏����Ȃ� fuck you!
			System.out.println("GameSaveLoader.exception�L�^�R��");
			System.out.println("��O��"+e);
	    }
		
	}
	public void LoadState(yukkurisim_main owner)
	{
		try
		{
			FileInputStream inFile = new FileInputStream("iurtilt.dat");
			ObjectInputStream inObject = new ObjectInputStream(inFile);
			
			mysavedata = (Vector<SaveData>) inObject.readObject();
			
			inFile.close();
			inObject.close();
		}
		catch(Exception e)
		{
			
		}
		
		// ************* �x�N�^�̒��g���Đ����� ***************** //
		int vsize = mysavedata.size();
		MapObject_Manager mapman = Physical_Law_Facade.Get_Instance(owner).Get_ObjectManager();

		for(int i=0;i<vsize;i++)
		{
			SaveData tmp = mysavedata.get(i);
			if(tmp.itemflag)
			{
				// �A�C�e���Ɋւ���f�[�^�ł���B
				ItemManager.Get_Instance(owner).setSaveData(tmp);
			}
			else
			{
				if(tmp.syuzoku==�萔.TYPE_�������object)
				{
					yukkuri_base	yukkuri_tmp = new yukkuri_base( owner );
					yukkuri_tmp.setSaveData(tmp);
					mapman.add( yukkuri_tmp,yukkuri_tmp.Get_Type() );
				}
				else if(tmp.syuzoku==�萔.TYPE_��object)
				{
					System.out.println("��");
					Tree_Object t = new Tree_Object(owner,tmp.my_x,tmp.my_y);
					t.setSaveData(tmp);
					mapman.add(t,t.Get_Type());
				}
				else if(tmp.syuzoku==�萔.TYPE_��object)
				{
					System.out.println("��");
					House_Object t = new House_Object(owner,tmp.my_x,tmp.my_y);
					t.setSaveData(tmp);
					mapman.add(t,t.Get_Type());
				}
			}
		}
	}
}
