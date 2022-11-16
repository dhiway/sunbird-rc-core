package dev.sunbirdrc.registry.util;

import com.fasterxml.jackson.databind.JsonNode;
import dev.sunbirdrc.pojos.OwnershipsAttributes;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDefinitionsManager {
    void loadDefinition() throws Exception;

    Set<String> getAllKnownDefinitions();
    List<Definition> getAllDefinitions();
    Definition getDefinition(String title);
    Map<String, Set<String>> getPublicFieldsInfoMap();
    Map<String, Set<String>> getExcludingFields();
    List<OwnershipsAttributes> getOwnershipAttributes(String entity);
    default Object getCredentialTemplate(String entityName) {
        return getDefinition(entityName).getOsSchemaConfiguration().getCredentialTemplate();
    }
    default Map<String, String> getCertificateTemplates(String entityName) {
        return getDefinition(entityName).getOsSchemaConfiguration().getCertificateTemplates();
    }
    boolean isValidEntityName(String entityName);
    void appendNewDefinition(JsonNode jsonNode);
    void removeDefinition(JsonNode jsonNode);
}