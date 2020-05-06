import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<IReviewed> stallAndAttractions;

    public ThemePark(ArrayList<IReviewed> stallAndAttractions) {
        this.stallAndAttractions = stallAndAttractions;
    }

    public ArrayList<IReviewed> getAllReviewed(){
        return this.stallAndAttractions;
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.addAttraction(attraction);
        attraction.increaseVisit();
    }

    public HashMap<Attraction, Integer> getHashMapReview(){
        HashMap<Attraction, Integer> reviewHashMap= new HashMap<>();
        for(IReviewed reviewedAttraction : this.stallAndAttractions){
            if(reviewedAttraction instanceof Attraction ){
                reviewHashMap.put((Attraction) reviewedAttraction, reviewedAttraction.getRating());
            }
        }
        return reviewHashMap;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allAllowedStallsAndAttractions= new ArrayList<>();
        for(IReviewed stallOrAttraction : this.stallAndAttractions){
            if(stallOrAttraction instanceof ISecurity){
                if(((ISecurity) stallOrAttraction).isAllowedTo(visitor)){
                    allAllowedStallsAndAttractions.add(stallOrAttraction);
                }
            }
        }
        return allAllowedStallsAndAttractions;
    }


}
