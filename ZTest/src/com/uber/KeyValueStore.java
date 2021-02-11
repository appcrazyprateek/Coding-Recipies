package com.uber;

import java.util.HashMap;
import java.util.Map;

interface IKeyValueStore {

		  // Insert a new key-value pair into the store.
		  void put(String key, String value);

		  // Delete a key from the store.
		  void delete(String key);

		  // Retrieve a key from the store. Throw error if key not found.
		  String get(String key) throws Exception;

		  // Retrieve the value of a key from a snapshot. Throw error
		  // if the key is not found.
		  String get(String key, String snapId) throws Exception;

		  // Take a snapshot of the store and refer to it as snapId.
		  //  Discard old snapshot with the same snapid, if it exists.
		  void takeSnapshot(String snapId);

		  // Delete a snapshot from the store. Throw error if no snapshot
		  // exists with snapid.
		  void deleteSnapshot(String snapid) throws Exception;
}

public class KeyValueStore implements IKeyValueStore {
	
    private Map<String,String> dataStore;
    private Map<String,Map<String,String>> snapshots;
    
    public KeyValueStore() {
		this.dataStore = new HashMap<>();
		this.snapshots = new HashMap<>();
	}

	@Override
	public void put(final String key, final String value) {
		// Validate key , Null and Empty Check using Guavas Annotation
		dataStore.put(key,value);
	}

	@Override
	public void delete(final String key) {
		// Validate key , Null and Empty Check using Guavas Annotation
		dataStore.remove(key);
	}

	@Override
	public String get(final String key) throws Exception {
		// Validate key , Null and Empty Check using Guavas Annotation
		
		if(!dataStore.containsKey(key)) {
			//Throw Custom Exception KeyNotFound Exception
			throw new Exception("KeyNotFound : " + key);
		}
		return dataStore.get(key);
	}
	
	
	
	@Override
	public String get(final String key, final String snapId) throws Exception {
		// Validate SnapId & Key , Null and Empty Check using Guavas Annotation
		
		if(!snapshots.containsKey(snapId)){
            return null;
        }
		
        Map<String, String> snapShot = snapshots.get(snapId);
        if(!snapShot.containsKey(key)) {
            //Throw Custom Exception KeyNotFound Exception
        	throw new Exception("KeyNotFound : " + key);
        }
        return snapShot.get(key);
	}

	@Override
	public void takeSnapshot(final String snapId) {
		// Validate SnapId , Null and Empty Check using Guavas
        
		Map<String, String> currentSnapshot = new HashMap<>();
		for (Map.Entry<String, String> entry : dataStore.entrySet()) {
			currentSnapshot.put(entry.getKey(), entry.getValue());
		}
		snapshots.put(snapId, currentSnapshot);
	}

	@Override
	public void deleteSnapshot(final String snapid) throws Exception {
		// Validate SnapId , Null and Empty Check using Guavas Annotation
		
		if(snapshots.containsKey(snapid)) {
			snapshots.remove(snapid);
		}
		else {
		//Throw Custom Exception SnapshotNotFound Expection
			throw new Exception("SnapShotNotFound : " + snapid);
		}
	}
	
	public static void main(String[] args) throws Exception {
	    KeyValueStore keyValueStore  = new KeyValueStore();
	    String snapId1 = "snapshot1";
	    String snapId2 = "snapshot2";
	    keyValueStore.put("1","1");
	    keyValueStore.put("2","2");
	    keyValueStore.put("3","3");
	    keyValueStore.put("4","4");
	    keyValueStore.put("5","5");
	    keyValueStore.takeSnapshot(snapId1);
	    
	    keyValueStore.put("1","101");
	    keyValueStore.put("2","102");
	    keyValueStore.put("3","103");
	    keyValueStore.put("4","104");
	    keyValueStore.put("5","105");
	    keyValueStore.takeSnapshot(snapId2);
	    
	    System.out.println("SnapId: "+snapId1+" Key: 1 "+"Value: "+keyValueStore.get("1",snapId1));
	    System.out.println("SnapId: "+snapId2+" Key: 1 "+"Value: "+keyValueStore.get("1",snapId2));

	    System.out.println("SnapId: "+snapId1+" Key: 2 "+"Value: "+keyValueStore.get("2",snapId1));
	    System.out.println("SnapId: "+snapId2+" Key: 2 "+"Value: "+keyValueStore.get("2",snapId2));

	    keyValueStore.deleteSnapshot(snapId1);
	    System.out.println("SnapId: "+snapId1+" Key: 1 "+"Value: "+keyValueStore.get("1",snapId1));


	}
}


//Time : O(1) 
//Space : O(n)
