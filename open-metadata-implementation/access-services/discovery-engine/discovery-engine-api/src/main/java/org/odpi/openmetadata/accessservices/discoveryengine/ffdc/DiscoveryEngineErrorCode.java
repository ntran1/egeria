/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.discoveryengine.ffdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * The DiscoveryEngineErrorCode is used to define first failure data capture (FFDC) for errors that occur when working with
 * the Discovery Engine OMAS Services.  It is used in conjunction with both Checked and Runtime (unchecked) exceptions.
 *
 * The 5 fields in the enum are:
 * <ul>
 *     <li>HTTP Error Code - for translating between REST and JAVA - Typically the numbers used are:</li>
 *     <li><ul>
 *         <li>500 - internal error</li>
 *         <li>400 - invalid parameters</li>
 *         <li>404 - not found</li>
 *         <li>409 - data conflict errors - eg item already defined</li>
 *     </ul></li>
 *     <li>Error Message Id - to uniquely identify the message</li>
 *     <li>Error Message Text - includes placeholder to allow additional values to be captured</li>
 *     <li>SystemAction - describes the result of the error</li>
 *     <li>UserAction - describes how a consumer should correct the error</li>
 * </ul>
 */
public enum DiscoveryEngineErrorCode
{
    SERVER_URL_NOT_SPECIFIED(400, "OMAS-DISCOVERY-ENGINE-400-001 ",
            "The OMAS Server URL is null",
            "The system is unable to connect to the OMAS Server to retrieve metadata properties.",
            "Ensure a valid OMAS Server URL is passed to the DiscoveryEngine when it is created."),
    SERVER_URL_MALFORMED(400, "OMAS-DISCOVERY-ENGINE-400-002 ",
            "The OMAS Server URL {0} is not in a recognized format",
            "The system is unable to connect to the OMAS Server to retrieve metadata properties.",
            "Ensure a valid OMAS Server URL is passed to the DiscoveryEngine when it is created."),
    NULL_USER_ID(400, "OMAS-DISCOVERY-ENGINE-400-003 ",
            "The user identifier (user id) passed on the {0} operation is null",
            "The system is unable to process the request without a user id.",
            "Correct the code in the caller to provide the user id."),
    NULL_GUID(400, "OMAS-DISCOVERY-ENGINE-400-004 ",
            "The unique identifier (guid) passed on the {0} parameter of the {1} operation is null",
            "The system is unable to process the request without a guid.",
            "Correct the code in the caller to provide the guid."),
    NULL_NAME(400, "OMAS-DISCOVERY-ENGINE-400-005 ",
            "The name passed on the {0} parameter of the {1} operation is null",
            "The system is unable to process the request without a name.",
            "Correct the code in the caller to provide the name."),
    INVALID_PROPERTY(400, "OMAS-DISCOVERY-ENGINE-400-006 ",
            "An unsupported property named {0} was passed to the repository services by the {1} request for open metadata access service {2} on server {3}; error message was: {4}",
            "The system is unable to process the request.",
            "Correct the types and property names of the properties passed on the request."),
    USER_NOT_AUTHORIZED(400, "OMAS-DISCOVERY-ENGINE-400-008 ",
            "User {0} is not authorized to issue the {1} request for open metadata access service {3} on server {4}",
            "The system is unable to process the request.",
            "Verify the access rights of the user."),
    PROPERTY_SERVER_ERROR(400, "OMAS-DISCOVERY-ENGINE-400-009 ",
            "An unexpected error was returned by the property server during {1} request for open metadata access service {2} on server {3}; message was {0}",
            "The system is unable to process the request.",
            "Verify the access rights of the user."),
    NULL_ENUM(400, "OMAS-DISCOVERY-ENGINE-400-010 ",
            "The enumeration value passed on the {0} parameter of the {1} operation is null",
            "The system is unable to process the request without this enumeration value.",
            "Correct the code in the caller to provide the name."),
    NULL_CONNECTION_PARAMETER(400, "OMAS-DISCOVERY-ENGINE-400-011 ",
            "The connection value passed on the {0} parameter of the {1} operation is null",
            "The system is unable to process the request without this value.",
            "Correct the code in the caller to provide the name."),
    NEGATIVE_START_FROM(400, "OMAS-DISCOVERY-ENGINE-400-012 ",
            "The starting point for the results, passed on the {0} parameter of the {1} operation, is negative",
            "The system is unable to process the request with this invalid value.  It should be zero for the start of the values, or a number greater than 0 to start partway down the list",
            "Correct the code in the caller to provide a non-negative value."),
    EMPTY_PAGE_SIZE(400, "OMAS-DISCOVERY-ENGINE-400-013 ",
            "The number of records to return, passed on the {0} parameter of the {1} operation, is less than 1",
            "The system is unable to process the request with this page size value.",
            "Correct the code in the caller to provide a page size of 1 or greater."),
    BAD_CONFIG(400, "OMAS-DISCOVERY-ENGINE-400-014",
            "The Discovery Engine Open Metadata Access Service (OMAS) has been passed an invalid value of {0} in the {1} property.  The resulting exception of {2} included the following message: {3}",
            "The access service has not been passed valid configuration.",
            "Correct the configuration and restart the service."),
    NULL_ARRAY_PARAMETER(400, "OMAS-DISCOVERY-ENGINE-400-015 ",
            "The array value passed on the {0} parameter of the {1} operation is null or empty",
            "The system is unable to process the request without this value.",
            "Correct the code in the caller to provide the name."),
    NULL_LOCAL_SERVER_NAME(400, "OMAS-DISCOVERY-ENGINE-400-016 ",
            "OMAG server has been called with a null local server name",
            "The system is unable to configure the local server.",
            "The local server name is supplied by the caller to the OMAG server. This call needs to be corrected before the server can operate correctly."),
    SERVER_NOT_AVAILABLE(404, "OMAS-DISCOVERY-ENGINE-404-001 ",
            "The OMAS Service {0} is not available",
            "The system is unable to connect to the OMAS Server.",
            "Check that the OMAS Server URL is correct and the OMAS Service is running.  Retry the request when the OMAS Service is available."),
    OMRS_NOT_INITIALIZED(404, "OMAS-DISCOVERY-ENGINE-404-002 ",
            "The open metadata repository services are not initialized for the {0} operation",
            "The system is unable to connect to the open metadata property server.",
            "Check that the server where the Discovery Engine OMAS is running initialized correctly.  " +
                      "Correct any errors discovered and retry the request when the open metadata services are available."),
    OMRS_NOT_AVAILABLE(404, "OMAS-DISCOVERY-ENGINE-404-003 ",
            "The open metadata repository services are not available for the {0} operation",
            "The system is unable to connect to the open metadata property server.",
            "Check that the server where the Discovery Engine OMAS is running initialized correctly.  " +
                       "Correct any errors discovered and retry the request when the open metadata services are available."),
    NO_METADATA_COLLECTION(404, "OMAS-DISCOVERY-ENGINE-404-004 ",
            "The repository connector {0} is not returning a metadata collection object",
            "The system is unable to access any metadata.",
            "Check that the open metadata server URL is correct and the server is running.  Report the error to the system administrator."),
    PROXY_ENTITY_FOUND(404, "OMAS-DISCOVERY-ENGINE-404-006 ",
            "Only an entity proxy for requested {0} object with unique identifier (guid) {1} is found in the open metadata server {2}, error message was: {3}",
            "The system is unable to populate the requested connection object.",
            "Check that the connection name and the OMAS Server URL are correct.  Retry the request when the connection is available in the OMAS Service"),
    MULTIPLE_RELATIONSHIPS_FOUND(404, "OMAS-DISCOVERY-ENGINE-404-008 ",
            "Multiple {0} relationships are connected to the {1} entity with unique identifier {2}: the relationship identifiers are {3}; the calling method is {4} and the server is {5}",
            "The system is unable to process a request because multiple relationships have been discovered and it is unsure which relationship to follow.",
            "Investigate why multiple relationships exist.  Then retry the request once the issue is resolve."),
    UNKNOWN_ENTITY(404, "OMAS-DISCOVERY-ENGINE-404-009 ",
            "The {0} with unique identifier {1} is not found for method {2} of access service {3} in open metadata server {4}, error message was: {5}",
            "The system is unable to update information associated with the asset because none of the connected open metadata repositories recognize the asset's unique identifier.",
            "The unique identifier of the asset is supplied by the caller.  Verify that the caller's logic is correct, and that there are no errors being reported by the open metadata repository. Once all errors have been resolved, retry the request."),
    NO_RELATIONSHIPS_FOUND(404, "OMAS-DISCOVERY-ENGINE-404-010 ",
            "No {0} relationships are connected to the {1} entity with unique identifier {2}: the calling method is {3} and the server is {4}",
            "The system is unable to process a request because no relationships have been discovered and it is unable to retrieve all of the information it needs.",
            "Check that the unique identifier is correct and the property server(s) supporting the assets is/are running."),
    NULL_ENTITY_RETURNED(404, "OMAS-DISCOVERY-ENGINE-404-011 ",
            "A null entity was returned to method {0} of server {1} during a request to create a new entity of type {2} (guid {3}) and properties of: {4}",
            "The system is unable to process a request .",
            "This may be a logic error or a configuration error.  Look for errors in the server's audit log and console to understand and correct the source of the error."),
    MULTIPLE_ENTITIES_FOUND(404, "OMAS-DISCOVERY-ENGINE-404-012 ",
            "Multiple {0} entities where found with a name of {1}: the identifiers of the returned entities are {2}; the calling method is {3}, the name parameter isd {4} and the server is {5}",
            "The system is unable to process a request because multiple relationships have been discovered and it is unsure which relationship to follow.",
            "Investigate why multiple relationships exist.  Then retry the request once the issue is resolve."),
    NULL_CONNECTION_RETURNED(500, "OMAS-DISCOVERY-ENGINE-500-001 ",
            "The requested connection named {0} is not returned by the open metadata Server {1}",
            "The system is unable to create a connector because the OMAS Server is not returning the Connection properties.",
            "Verify that the OMAS server running and the connection definition is correctly configured."),
    NULL_CONNECTOR_RETURNED(500, "OMAS-DISCOVERY-ENGINE-500-002 ",
            "The requested connector for connection named {0} is not returned by the OMAS Server {1}",
            "The system is unable to create a connector.",
            "Verify that the OMAS server is running and the connection definition is correctly configured."),
    NULL_END2_RETURNED(500, "OMAS-DISCOVERY-ENGINE-500-003 ",
            "A relationship of type {0} and unique identifier of {1} has a null entity proxy 2.  Relationship contents are: {2}",
            "The system is unable to retrieve the asset.",
            "This is a logic error in the open metadata repositories as it is not valid to have a relationship without two entity proxies that represent the entities that is connects.  Gather as much information about the usage of the metadata.  Use the metadata collection id to identify which server owns the relationship and raise an issue."),
    NULL_RESPONSE_FROM_API(503, "OMAS-DISCOVERY-ENGINE-503-001 ",
            "A null response was received from REST API call {0} to server {1}",
            "The system has issued a call to an open metadata access service REST API in a remote server and has received a null response.",
            "Look for errors in the remote server's audit log and console to understand and correct the source of the error."),
    CLIENT_SIDE_REST_API_ERROR(503, "OMAS-DISCOVERY-ENGINE-503-002 ",
            "A client-side exception {0} was received from API call {1} to server {2} at {3}.  The error message was {4}",
            "The client has issued a call to the open metadata access service REST API in a remote server and has received an exception from the local client libraries.",
            "Review the error message to determine the cause of the error.  Check that the server is running an the URL is correct. Look for errors in the local server's console to understand and correct the cause of the error. Then rerun the request"),
    SERVICE_NOT_INITIALIZED(503, "OMAS-DISCOVERY-ENGINE-503-003 ",
            "The access service has not been initialized for server {0} and can not support REST API call {1}",
            "The server has received a call to one of its open metadata access services but is unable to process it because the access service is not active.",
            "If the server is supposed to have this access service activated, correct the server configuration and restart the server."),
    EXCEPTION_RESPONSE_FROM_API(503, "OMAS-DISCOVERY-ENGINE-503-004 ",
            "A {0} exception was received from REST API call {1} to server {2}: error message was: {3}",
            "The system has issued a call to an open metadata access service REST API in a remote server and has received an exception response.",
            "The error message should indicate the cause of the error.  Otherwise look for errors in the remote server's audit log and console to understand and correct the source of the error.")
    ;


    private int    httpErrorCode;
    private String errorMessageId;
    private String errorMessage;
    private String systemAction;
    private String userAction;

    private static final Logger log = LoggerFactory.getLogger(DiscoveryEngineErrorCode.class);


    /**
     * The constructor for DiscoveryEngineErrorCode expects to be passed one of the enumeration rows defined in
     * DiscoveryEngineErrorCode above.   For example:
     *
     *     DiscoveryEngineErrorCode   errorCode = DiscoveryEngineErrorCode.ASSET_NOT_FOUND;
     *
     * This will expand out to the 5 parameters shown below.
     *
     * @param newHTTPErrorCode - error code to use over REST calls
     * @param newErrorMessageId - unique Id for the message
     * @param newErrorMessage - text for the message
     * @param newSystemAction - description of the action taken by the system when the error condition happened
     * @param newUserAction - instructions for resolving the error
     */
    DiscoveryEngineErrorCode(int  newHTTPErrorCode, String newErrorMessageId, String newErrorMessage, String newSystemAction, String newUserAction)
    {
        this.httpErrorCode = newHTTPErrorCode;
        this.errorMessageId = newErrorMessageId;
        this.errorMessage = newErrorMessage;
        this.systemAction = newSystemAction;
        this.userAction = newUserAction;
    }


    public int getHTTPErrorCode()
    {
        return httpErrorCode;
    }


    /**
     * Returns the unique identifier for the error message.
     *
     * @return errorMessageId
     */
    public String getErrorMessageId()
    {
        return errorMessageId;
    }


    /**
     * Returns the error message with placeholders for specific details.
     *
     * @return errorMessage (unformatted)
     */
    public String getUnformattedErrorMessage()
    {
        return errorMessage;
    }


    /**
     * Returns the error message with the placeholders filled out with the supplied parameters.
     *
     * @param params - strings that plug into the placeholders in the errorMessage
     * @return errorMessage (formatted with supplied parameters)
     */
    public String getFormattedErrorMessage(String... params)
    {
        log.debug(String.format("<== DiscoveryEngineErrorCode.getMessage(%s)", Arrays.toString(params)));

        MessageFormat mf = new MessageFormat(errorMessage);
        String result = mf.format(params);

        log.debug(String.format("==> DiscoveryEngineErrorCode.getMessage(%s): %s", Arrays.toString(params), result));

        return result;
    }


    /**
     * Returns a description of the action taken by the system when the condition that caused this exception was
     * detected.
     *
     * @return systemAction
     */
    public String getSystemAction()
    {
        return systemAction;
    }


    /**
     * Returns instructions of how to resolve the issue reported in this exception.
     *
     * @return userAction
     */
    public String getUserAction()
    {
        return userAction;
    }


    /**
     * JSON-style toString
     *
     * @return string of property names and values for this enum
     */
    @Override
    public String toString()
    {
        return "DiscoveryEngineErrorCode{" +
                "httpErrorCode=" + httpErrorCode +
                ", errorMessageId='" + errorMessageId + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", systemAction='" + systemAction + '\'' +
                ", userAction='" + userAction + '\'' +
                '}';
    }
}
