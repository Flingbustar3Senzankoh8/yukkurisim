package yukkurisim;

import java.awt.image.BufferedImage;

/* ���̑��̃I�u�W�F�N�g�B�@�P�ɉ摜��\�������肵�������ɁB */
/* �����X�v���C�g�^�C�v�͖��g�p�ƂȂ� */
public class Other_Object extends Object_base {

	public Other_Object(yukkurisim_main own) {
		super(own);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	public Other_Object(yukkurisim_main own, BufferedImage[] arg0) {
		super(own, arg0);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	public Other_Object(yukkurisim_main own, double arg0, double arg1) {
		super(own, arg0, arg1);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	public Other_Object(yukkurisim_main own, BufferedImage[] arg0, double arg1,
			double arg2) {
		super(own, arg0, arg1, arg2);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	public int Get_Type() {
		return �萔.TYPE_���g�p;
	}

	public void doClickEvent() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	public boolean isCharactor()
	{
		return false;	// ����̓L�����N�^�[�ł͂Ȃ�
	}

	@Override
	public void doOnMouseEvent() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

}
