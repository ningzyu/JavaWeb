package cn.wintec.nzy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NZY on 2017/8/22.
 */

public class Pos {

    private String result;//请求结果
    private List<PosTypes> ptypes;//分类项集合

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
        private String title;    //标题
        private String icon;    //图片
        private List<PosItem> items;  //pos机集合
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
       private String name;     //名字
       private String image;     //展示图片
       private List<String> banners;     //轮播图片集合
       private String synopsis;     //简介
       private List<Params> paralist;//技术参数集合
       private List<String> traits;//产品特点集合
       private String video;//视屏
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
  
    //技术参数
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
