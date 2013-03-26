package ar.com.epidataconsulting.principles.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class Connection {
	
	private boolean inUse = false;
	
	private static Map<String, Map<String, Map<String, Object>>> collections =
			new HashMap<String, Map<String,Map<String,Object>>>();
	
	protected Connection() {
	}
	
	public void open() {
		if (inUse) {
			throw new ConnectionInUseException();
		}
		inUse = true;
	}
	
	public void close() {
		inUse = false;
	}
	
	public boolean isInUse() {
		return inUse;
	}
	
	public Map<String, Object> findById(String collectionName, String id) {
		Map<String, Map<String, Object>> collection = collections.get(collectionName);
		if (collection == null) {
			throw new UnknownCollectionException(collectionName);
		}
		return collection.get(id);
	}
	
	public Map<String, Object> findByKey(String collectionName, String key, Object value) {
		Map<String, Map<String, Object>> collection = collections.get(collectionName);
		if (collection == null) {
			throw new UnknownCollectionException(collectionName);
		}
		for (Map.Entry<String, Map<String, Object>> entry : collection.entrySet()) {
			Map<String, Object> element = entry.getValue();
			Object val = element.get(key);
			if (value.equals(val)) {
				return element;
			}
		}
		return null;
	}
	
	public void insert(String collectionName, Map<String, Object> element) {
		Map<String, Map<String, Object>> collection = collections.get(collectionName);
		// If the collection hasn't exists, I create it
		if (collection == null) {
			collection = new HashMap<String, Map<String,Object>>();
			collections.put(collectionName, collection);
		}
		// If element doesn't have an id, then the connection generates one
		String id = (String) element.get("id");
		if (StringUtils.isBlank(id)) {
			id = UUID.randomUUID().toString();
			element.put("id", id);
		}
		// Save the element in the collection
		collection.put(id, element);
	}
	
	public List<Map<String, Object>> findAll(String collectionName) {
		Map<String, Map<String, Object>> collection = collections.get(collectionName);
		if (collection == null) {
			throw new UnknownCollectionException(collectionName);
		}
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for (Map.Entry<String, Map<String, Object>> entry : collection.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
	
	public void delete(String collectionName, String id) {
		Map<String, Map<String, Object>> collection = collections.get(collectionName);
		if (collection == null) {
			throw new UnknownCollectionException(collectionName);
		}
		collection.remove(id);
	}
	
}
