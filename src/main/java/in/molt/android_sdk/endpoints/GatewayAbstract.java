package in.molt.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import in.molt.android_sdk.utilities.Constants;
import in.molt.android_sdk.utilities.Preferences;

//handling API calls for the endpoint
public class GatewayAbstract extends HttpMethodAbstract {

    public Preferences preferences;

    public GatewayAbstract(Preferences preferences)
    {
        this.preferences = preferences;
    }

    public void get(String slug, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "gateway/" + slug;

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void list(JSONObject terms, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "gateways";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, terms, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
