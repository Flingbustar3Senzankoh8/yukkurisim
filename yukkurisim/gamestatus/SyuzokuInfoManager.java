package gamestatus;

public class SyuzokuInfoManager{
	protected  Const_Value �萔 = new Const_Value();
	
	public String Get_SyuzokuName(int SyuzokuNo)
	{
		if(SyuzokuNo==�萔.TYPE_�������object)
		{
			return "�ꂢ��";
		}
		else if(SyuzokuNo==�萔.TYPE_�܂肳object)
		{
			return "�܂肳";
		}
		return "NULL";
	}
	
	/** ��̔\�͂𕶎������郁�\�b�h�B
	 */
	public String Get_rank_kari(int input)
	{
		String[] serifu={	"���ɂ܂񂶂イ",
							"�ӂ��΂ƂԂ��",
							"��邫������̂�",
							"�������P�L��",
							"�����ʈȉ�",
							"������肵�Ă�ˁI",
							"������������",
							"�����炱���ς�[",
							"���������������",
							"�ł񂹂ɂȂ��Ă�"};

		for(int i=0;i<10;i++)
		{
			if(	(input>=(�萔.C_�X�e�[�^�X�ő�l*i/10))&&
				(input<(�萔.C_�X�e�[�^�X�ő�l*(i+1)/10)))
			{
				return serifu[i];
			}
		}
		if(input==�萔.C_�X�e�[�^�X�ő�l)
		{
			return "�}�b�n�ŗL���V";
		}
		return null;
	}
	
	/**�������𕶎������郁�\�b�h�B
	 */
	public String Get_rank_Cooperative(int input)
	{
		String[] serifu={	"�m���̂�������Ȃ�",
				"�ǂ����Ă��Q�X",
				"���҂����畉��",
				"���肬�蓮��",
				"�����ʈȉ�",
				"������肵�Ă�ˁI",
				"���΂ł���",
				"����������",
				"��������Ƒ��X�y�V����",
				"���Ȃ��Ƃ�������������"};

		for(int i=0;i<10;i++)
		{
		if(	(input>=(�萔.C_�X�e�[�^�X�ő�l*i/10))&&
			(input<(�萔.C_�X�e�[�^�X�ő�l*(i+1)/10)))
		{
			return serifu[i];
		}
		}
		if(input==�萔.C_�X�e�[�^�X�ő�l)
		{
		return "�݂�Ȃ�����肵�Ă����ĂˁI";
		}
		return null;

	}
}