package gamestatus;

import java.io.Serializable;
import java.util.HashMap;

/**** �Z�[�u�f�[�^�^�̒�` ****/
public class SaveData implements Serializable
{
	public boolean itemflag;
	public int itemindex;
	public int itemcount;
	public boolean ItemKnowledge;
	////////////// itemflag���^�Ȃ�΁����]�������
	
	public int syuzoku;
	public int birthday;
	public int hp;
	public int growlv;
	public int exp;
	public int hungry;
	public int sweety;
	public int happy;
	public int dex;
	public int cooper;
	public int hunt;
	public int state;
	public int my_x;
	public int my_y;
	
	////////////// �g���p�Ɏg�p����
	public HashMap<String,String> Others;
}
