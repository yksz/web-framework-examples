package util

class Message {

    static final BASE_NAME = 'i18n.messages'

    static ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME)

    static String get(String key) {
        return bundle.getString(key)
    }

}
