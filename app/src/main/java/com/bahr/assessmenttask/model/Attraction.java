
package com.bahr.assessmenttask.model;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.bahr.assessmenttask.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.databinding.BindingAdapter;

public class Attraction {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_active")
    @Expose
    private Object isActive;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("arabic_name")
    @Expose
    private String arabicName;
    @SerializedName("arabic_description")
    @Expose
    private String arabicDescription;
    @SerializedName("facebook")
    @Expose
    private Object facebook;
    @SerializedName("twitter")
    @Expose
    private Object twitter;
    @SerializedName("instagram")
    @Expose
    private Object instagram;
    @SerializedName("working_hours")
    @Expose
    private List<Object> workingHours = null;
    @SerializedName("photos")
    @Expose
    private List<String> photos = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("offers")
    @Expose
    private List<Object> offers = null;
    @SerializedName("tryps_id")
    @Expose
    private String trypsId;
    @SerializedName("markup")
    @Expose
    private Object markup;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("duration_unit")
    @Expose
    private String durationUnit;
    @SerializedName("general_terms")
    @Expose
    private String generalTerms;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("exlcude")
    @Expose
    private String exlcude;
    @SerializedName("city")
    @Expose
    private City city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getIsActive() {
        return isActive;
    }

    public void setIsActive(Object isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public Object getTwitter() {
        return twitter;
    }

    public void setTwitter(Object twitter) {
        this.twitter = twitter;
    }

    public Object getInstagram() {
        return instagram;
    }

    public void setInstagram(Object instagram) {
        this.instagram = instagram;
    }

    public List<Object> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<Object> workingHours) {
        this.workingHours = workingHours;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public String getTrypsId() {
        return trypsId;
    }

    public void setTrypsId(String trypsId) {
        this.trypsId = trypsId;
    }

    public Object getMarkup() {
        return markup;
    }

    public void setMarkup(Object markup) {
        this.markup = markup;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getGeneralTerms() {
        return generalTerms;
    }

    public void setGeneralTerms(String generalTerms) {
        this.generalTerms = generalTerms;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getExlcude() {
        return exlcude;
    }

    public void setExlcude(String exlcude) {
        this.exlcude = exlcude;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }



    @BindingAdapter({ "category" })
    public static void category(TextView textView, List<Category> categories) {

        if(categories!=null&&categories.size()!=0) {

            textView.setText(categories.get(0).getName());

        }


    }

    @BindingAdapter({ "avatar" })
    public static void loadImage(ImageView imageView, List<String> photos) {
        if(photos!=null&&photos.size()!=0) {
            Glide.with(imageView.getContext())
                    .setDefaultRequestOptions(new RequestOptions()
                    )
                    .load(photos.get(0))
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.imagenotfound)
                    .into(imageView);



        }else{
            imageView.setImageResource(R.drawable.imagenotfound);
        }
    }

}
