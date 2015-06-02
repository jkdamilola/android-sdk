package moltin.android_sdk.models;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brand {

    private String title=null;
    private String slug=null;
    private String status=null;
    private String description=null;

    public Brand()
    {

    }

    public Brand(Object object) throws Exception {
        this((JSONObject)object);
    }

    public Brand(JSONObject json) throws Exception {
        try
        {
            if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && !json.isNull("result") && json.get("result") instanceof JSONObject)
            {
                json = json.getJSONObject("result");
            }
            if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && !json.isNull("result") && json.getJSONArray("result").length()==1)
            {
                json = json.getJSONArray("result").getJSONObject(0);
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && !json.isNull("result") && json.getJSONArray("result").length()>1)
            {
                throw new Exception("multiple items, expected single item to parse");
            }else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && !json.isNull("result") && json.getJSONArray("result").length()<1)
            {
                throw new Exception("zero items, expected single item to parse");
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && json.isNull("result"))
            {
                throw new Exception("no items to parse");
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && !json.getBoolean("status") && json.has("errors") && !json.isNull("errors"))
            {
                String errors="status is false";
                for(int i=0;i<json.getJSONArray("errors").length();i++)
                {
                    errors += "\n" + json.getJSONArray("errors").getString(i);
                }
                throw new Exception(errors);
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && !json.getBoolean("status") && json.has("error") && !json.isNull("error"))
            {
                throw new Exception(json.getString("error"));
            }

            if(json.has("title") && !json.isNull("title"))
                title = (String)json.get("title");

            if(json.has("slug") && !json.isNull("slug"))
                slug = (String)json.get("slug");

            if(json.has("description") && !json.isNull("description"))
                description = (String)json.get("description");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(title!=null) json.put("title",title);
            if(slug!=null) json.put("slug",slug);
            if(status!=null) json.put("status",status);
            if(description!=null) json.put("description",description);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}