package cn.wintec.nzy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NZY on 2017/8/22.
 */

public class Pos {

    private String result;//������
    private List<PosTypes> ptypes;//�������

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PosTypes> getPtypes() {
        return ptypes;
    }

    public void setPtypes(List<PosTypes> ptypes) {
        this.ptypes = ptypes;
    }

    public static class PosTypes{
        private int id;
        private String title;    //����
        private String icon;    //ͼƬ
        private List<PosItem> items;  //pos������
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<PosItem> getItems() {
            return items;
        }

        public void setItems(List<PosItem> items) {
            this.items = items;
        }
    }
    
    
    public static  class PosItem{
       private int id;
       private int typeid;
       private String name;     //����
       private String image;     //չʾͼƬ
       private List<String> banners;     //�ֲ�ͼƬ����
       private String synopsis;     //���
       private List<Params> paralist;//������������
       private List<String> traits;//��Ʒ�ص㼯��
       private String video;//����
        public List<Params> getParalist() {
		return paralist;
	}

	public void setParalist(String[] paralist) {
		List<Params> plist=new ArrayList<Pos.Params>();
		for(String s:paralist){
			String []ps=s.split("-");
			plist.add(new Params(ps[0], ps[1]));
		}
		this.paralist = plist;
	}

	public List<String> getTraits() {
		return traits;
	}

	public void setTraits(String[] traits) {
		List<String> list=new ArrayList<String>();
		for(String s:traits){
			list.add(s);
		}
		this.traits = list;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

		public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        private String trait;

		public String getTrait() {
			return trait;
		}

		public void setTrait(String trait) {
			this.trait = trait;
		} 
        public int getTypeid() {
            return typeid;
        }

        public void setTypeid(int typeid) {
            this.typeid = typeid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<String> getBanners() {
            return banners;
        }

        public void setBanners(String [] banners) {
        	List<String> list=new ArrayList<String>();
        	for(String img:banners){
        		list.add(img);
        	}
            this.banners = list;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public void setSynopsis(String synopsis) {
            this.synopsis = synopsis;
        }
    }
  
    //��������
    public static  class Params{
    	private String paramname;
    	private String paramcontent;
    	
    	public Params() {
    	}
    	public Params(String paramname, String paramcontent) {
    		super();
    		this.paramname = paramname;
    		this.paramcontent = paramcontent;
    	}
    	public String getParamname() {
    		return paramname;
    	}
    	public void setParamname(String paramname) {
    		this.paramname = paramname;
    	}
    	public String getParamcontent() {
    		return paramcontent;
    	}
    	public void setParamcontent(String paramcontent) {
    		this.paramcontent = paramcontent;
    	}
    }
}
