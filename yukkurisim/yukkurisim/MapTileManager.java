package yukkurisim;
import java.io.Serializable;

import yukkurisim.yukkurisim_main;
import yukkurisim.ADV_SpriteGroup_base;
import gamestatus.Const_Value;


/****
 * �}�b�v�^�C���}�l�[�W���B�@�}�b�v�̊Ǘ����s���B�@MapObjectManager�̓}�b�v��̃I�u�W�F�N�g��
 * �Ǘ����s�����̂ŁA����Ƃ͈قȂ�}�b�v���̂��̂̊Ǘ����s���B
 * @author pochiel
 *
 */
public class MapTileManager implements Serializable {
	private yukkurisim_main		owner;
	private  Const_Value			�萔 = new Const_Value();
	public ADV_SpriteGroup_base		map1;

	/* �}�b�v���Ǘ��N���XMapTilesub */
	public class MapTilesub implements Serializable {
		private int sub_x;
		private int sub_y;
		private int sub_type;
		
		private MapTilesub(int x , int y ,int type)
		{
			sub_x = x;
			sub_y = y;
			sub_type = type;
		}
		
		public int Get_x()
		{
			return sub_x;
		}
		
		public int Get_y()
		{
			return sub_y;
		}
		
		public int Get_Type()
		{
			return sub_type;
		}
	}
	private MapTilesub[][] map_info;
	private int[][] mapdef;
	public MapTileManager( yukkurisim_main own , int[][] mapgrid){
		
		owner = own;
		mapdef = mapgrid;
		map1 = new ADV_SpriteGroup_base(owner,"MAP1");
		map_info = new MapTilesub[�萔.��ʉ��Z����][�萔.��ʏc�Z����];
		
    	for( int i = 0 ; i < �萔.��ʏc�Z���� ; i++ )
    	{ 
    		for( int j = 0 ; j < �萔.��ʉ��Z���� ; j++ )
    		{
    			int type_tmp=0;
    			switch( mapgrid[i][j] )
    			{
    			case 0:
    				//���݂͎������Ă��Ȃ�
    				map1.add(	new Mapchip_base
								(
									owner , 
									//owner.getImages("image/mapchip/paneldefault.gif",1,1),
									ImageLoader.Get_Instance(owner).getBufferedImage(�萔.�摜�ԍ�_�^�C��0),
									j,
									i,
									�萔.TYPE_���̂݉\
								)
    				
    				);
    				type_tmp=�萔.TYPE_���̂݉\;
    				break;
    			case 1:		//����1
    				map1.add(	new Mapchip_base
    							(
    								owner , 
    								//owner.getImages("image/sougen1.gif",1,1),
    								ImageLoader.Get_Instance(owner).getBufferedImage(�萔.�摜�ԍ�_����1),
    								j,
    								i,
    								�萔.TYPE_�ʍs�̂݉\
    							)
    				);
    				type_tmp=�萔.TYPE_�ʍs�̂݉\;
    				break;
    			case 2:		//����2
    				map1.add( new Mapchip_base
    						(
    							owner , 
    							//owner.getImages("image/sougen2.gif",1,1),
								ImageLoader.Get_Instance(owner).getBufferedImage(�萔.�摜�ԍ�_����2),
    							j,
    							i,
    							�萔.TYPE_�ʍs�̂݉\
    						)
    				);
    				type_tmp=�萔.TYPE_�ʍs�̂݉\;
    				break;
    			case 3:		//��1
    				map1.add( new Mapchip_base
    						(
    							owner , 
    							//owner.getImages("image/river1.gif",1,1),
								ImageLoader.Get_Instance(owner).getBufferedImage(�萔.�摜�ԍ�_��1),
    							j,
    							i,
    							�萔.TYPE_���̂݉\
    						)
    				);
    				type_tmp=�萔.TYPE_���̂݉\;
    				break;
    			case 4:		//��2
    				map1.add( new Mapchip_base
    						(
    							owner , 
    							//owner.getImages("image/river2.gif",1,1),
								ImageLoader.Get_Instance(owner).getBufferedImage(�萔.�摜�ԍ�_��2),
    							j,
    							i,
    							�萔.TYPE_���̂݉\
    						)
    				);
    				type_tmp=�萔.TYPE_���̂݉\;
    				break;
    			case 5:		//�G���g�����X
    				map1.add( new Mapchip_base
    						(
    							owner , 
    							//owner.getImages("image/enterance.gif",1,1),
								ImageLoader.Get_Instance(owner).getBufferedImage(�萔.�摜�ԍ�_�G���g�����X),
    							j,
    							i,
    							�萔.TYPE_���̂݉\
    						)
    				);
    				type_tmp=�萔.TYPE_���̂݉\;
    				break;
    			}
    			map_info[j][i] = new MapTilesub(j,i,type_tmp);		// �}�b�v�Ǘ��N���X��
				// �}�b�v�����i�[

    		}
    	}
	}
	
	/**
	 * Map�̎��̂ւ�Getter
	 * @return
	 */
	public	ADV_SpriteGroup_base GetMapGroup()
	{
		return map1;
	}
	
	// �Z���̃}�b�v�^�C�v��Ԃ�
	public int Get_Cell_Type(int cellx , int celly)
	{
		return map_info[cellx][celly].sub_type;
	}
	
	
	// �Y���I�u�W�F�N�g���Y���}�b�v�ɐi���ł��邩��Ԃ�
	public boolean Check_able_to_Entry(int cell_x,int cell_y,int c_type)
	{
		if( c_type == �萔.TYPE_�������object )
		{	
			// �������I�u�W�F�N�g�̐i���\������������
			int t = this.Get_Cell_Type(cell_x, cell_y);
			if( (t==�萔.TYPE_���ׂĂ��\)||(t==�萔.TYPE_�ʍs�̂݉\))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	
	// �Y���I�u�W�F�N�g�ɐݒu�^�I���}�b�v�I�u�W�F�N�g���ݒu�\�ł��邩��Ԃ�
	public boolean Check_able_to_Build(int cell_x,int cell_y,int cell_w , int cell_h)
	{
    	double dmy_y = cell_y;
    	double dmy_x = cell_x;
		    	
		for(int j=cell_h-1;j>=0;j--)
		{
			dmy_x=cell_x+(0.5*j);
			dmy_y=cell_y-j;
	    	if(cell_y%2!=0)
			{
				dmy_x+=0.5;		// y�ʒu�ɂ�鉡�ʒu�␳
			}
			
	    	for(int i=0;i<cell_w;i++)
	    	{	//����
	    		int tmpx = (int)dmy_x;
	    		int tmpy = (int)dmy_y;
	    		// �`�F�b�N���Ă���Z������ʂ��n�~�o����
	    		if( (tmpx<0)||(tmpx>=�萔.��ʉ��Z����))
	    		{
	    			return false;
	    		}
	    		if( (tmpy<0)||(tmpy>=�萔.��ʏc�Z����))
	    		{
	    			return false;
	    		}
	    		
	    		// �����ȊO�̃}�b�v�^�C����ɃI�u�W�F�N�g�����Ă悤�Ƃ���
	    		if( mapdef[tmpy][tmpx]!=1 )
	    		{
	    			return false;
	    		}
				dmy_x+=0.5;
				dmy_y++;
	    	}			
		}
		return true;
	}
	
}
