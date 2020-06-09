// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Set;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.io.Serializable;
import java.util.AbstractMap;

public final class LinkedTreeMap extends AbstractMap implements Serializable
{
    private static final Comparator NATURAL_ORDER;
    Comparator comparator;
    private LinkedTreeMap$EntrySet entrySet;
    final LinkedTreeMap$Node header;
    private LinkedTreeMap$KeySet keySet;
    int modCount;
    LinkedTreeMap$Node root;
    int size;
    
    static {
        NATURAL_ORDER = new LinkedTreeMap$1();
    }
    
    public LinkedTreeMap() {
        this(LinkedTreeMap.NATURAL_ORDER);
    }
    
    public LinkedTreeMap(final Comparator comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new LinkedTreeMap$Node();
        Comparator natural_ORDER;
        if (comparator != null) {
            natural_ORDER = comparator;
        }
        else {
            natural_ORDER = LinkedTreeMap.NATURAL_ORDER;
        }
        this.comparator = natural_ORDER;
    }
    
    private boolean equal(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    private void rebalance(final LinkedTreeMap$Node linkedTreeMap$Node, final boolean b) {
        for (LinkedTreeMap$Node parent = linkedTreeMap$Node; parent != null; parent = parent.parent) {
            final LinkedTreeMap$Node left = parent.left;
            final LinkedTreeMap$Node right = parent.right;
            int n = 0;
            int height;
            if (left != null) {
                height = left.height;
            }
            else {
                height = 0;
            }
            int height2;
            if (right != null) {
                height2 = right.height;
            }
            else {
                height2 = 0;
            }
            final int n2 = height - height2;
            if (n2 == -2) {
                final LinkedTreeMap$Node left2 = right.left;
                final LinkedTreeMap$Node right2 = right.right;
                int height3;
                if (right2 != null) {
                    height3 = right2.height;
                }
                else {
                    height3 = 0;
                }
                if (left2 != null) {
                    n = left2.height;
                }
                final int n3 = n - height3;
                if (n3 != -1 && (n3 != 0 || b)) {
                    this.rotateRight(right);
                    this.rotateLeft(parent);
                }
                else {
                    this.rotateLeft(parent);
                }
                if (b) {
                    break;
                }
            }
            else {
                final int n4 = 2;
                final int n5 = 1;
                if (n2 == n4) {
                    final LinkedTreeMap$Node left3 = left.left;
                    final LinkedTreeMap$Node right3 = left.right;
                    int height4;
                    if (right3 != null) {
                        height4 = right3.height;
                    }
                    else {
                        height4 = 0;
                    }
                    if (left3 != null) {
                        n = left3.height;
                    }
                    final int n6 = n - height4;
                    if (n6 != n5 && (n6 != 0 || b)) {
                        this.rotateLeft(left);
                        this.rotateRight(parent);
                    }
                    else {
                        this.rotateRight(parent);
                    }
                    if (b) {
                        break;
                    }
                }
                else if (n2 == 0) {
                    parent.height = height + 1;
                    if (b) {
                        break;
                    }
                }
                else {
                    parent.height = Math.max(height, height2) + n5;
                    if (!b) {
                        break;
                    }
                }
            }
        }
    }
    
    private void replaceInParent(final LinkedTreeMap$Node linkedTreeMap$Node, final LinkedTreeMap$Node root) {
        final LinkedTreeMap$Node parent = linkedTreeMap$Node.parent;
        linkedTreeMap$Node.parent = null;
        if (root != null) {
            root.parent = parent;
        }
        if (parent != null) {
            if (parent.left == linkedTreeMap$Node) {
                parent.left = root;
            }
            else {
                parent.right = root;
            }
        }
        else {
            this.root = root;
        }
    }
    
    private void rotateLeft(final LinkedTreeMap$Node linkedTreeMap$Node) {
        final LinkedTreeMap$Node left = linkedTreeMap$Node.left;
        final LinkedTreeMap$Node right = linkedTreeMap$Node.right;
        final LinkedTreeMap$Node left2 = right.left;
        final LinkedTreeMap$Node right2 = right.right;
        linkedTreeMap$Node.right = left2;
        if (left2 != null) {
            left2.parent = linkedTreeMap$Node;
        }
        this.replaceInParent(linkedTreeMap$Node, right);
        right.left = linkedTreeMap$Node;
        linkedTreeMap$Node.parent = right;
        int height = 0;
        int height2;
        if (left != null) {
            height2 = left.height;
        }
        else {
            height2 = 0;
        }
        int height3;
        if (left2 != null) {
            height3 = left2.height;
        }
        else {
            height3 = 0;
        }
        linkedTreeMap$Node.height = Math.max(height2, height3) + 1;
        final int height4 = linkedTreeMap$Node.height;
        if (right2 != null) {
            height = right2.height;
        }
        right.height = Math.max(height4, height) + 1;
    }
    
    private void rotateRight(final LinkedTreeMap$Node linkedTreeMap$Node) {
        final LinkedTreeMap$Node left = linkedTreeMap$Node.left;
        final LinkedTreeMap$Node right = linkedTreeMap$Node.right;
        final LinkedTreeMap$Node left2 = left.left;
        final LinkedTreeMap$Node right2 = left.right;
        linkedTreeMap$Node.left = right2;
        if (right2 != null) {
            right2.parent = linkedTreeMap$Node;
        }
        this.replaceInParent(linkedTreeMap$Node, left);
        left.right = linkedTreeMap$Node;
        linkedTreeMap$Node.parent = left;
        int height = 0;
        int height2;
        if (right != null) {
            height2 = right.height;
        }
        else {
            height2 = 0;
        }
        int height3;
        if (right2 != null) {
            height3 = right2.height;
        }
        else {
            height3 = 0;
        }
        linkedTreeMap$Node.height = Math.max(height2, height3) + 1;
        final int height4 = linkedTreeMap$Node.height;
        if (left2 != null) {
            height = left2.height;
        }
        left.height = Math.max(height4, height) + 1;
    }
    
    private Object writeReplace() {
        return new LinkedHashMap(this);
    }
    
    public void clear() {
        this.root = null;
        this.size = 0;
        ++this.modCount;
        final LinkedTreeMap$Node header = this.header;
        header.prev = header;
        header.next = header;
    }
    
    public boolean containsKey(final Object o) {
        return this.findByObject(o) != null;
    }
    
    public Set entrySet() {
        final LinkedTreeMap$EntrySet entrySet = this.entrySet;
        LinkedTreeMap$EntrySet entrySet2;
        if (entrySet != null) {
            entrySet2 = entrySet;
        }
        else {
            entrySet2 = new LinkedTreeMap$EntrySet(this);
            this.entrySet = entrySet2;
        }
        return entrySet2;
    }
    
    LinkedTreeMap$Node find(final Object o, final boolean b) {
        final Comparator comparator = this.comparator;
        LinkedTreeMap$Node root = this.root;
        int n = 0;
        if (root != null) {
            Comparable<Object> comparable;
            if (comparator == LinkedTreeMap.NATURAL_ORDER) {
                comparable = (Comparable<Object>)o;
            }
            else {
                comparable = null;
            }
            while (true) {
                int n2;
                if (comparable != null) {
                    n2 = comparable.compareTo(root.key);
                }
                else {
                    n2 = comparator.compare(o, root.key);
                }
                n = n2;
                if (n2 == 0) {
                    return root;
                }
                LinkedTreeMap$Node linkedTreeMap$Node;
                if (n2 < 0) {
                    linkedTreeMap$Node = root.left;
                }
                else {
                    linkedTreeMap$Node = root.right;
                }
                if (linkedTreeMap$Node == null) {
                    break;
                }
                root = linkedTreeMap$Node;
            }
        }
        if (!b) {
            return null;
        }
        final LinkedTreeMap$Node header = this.header;
        final int n3 = 1;
        LinkedTreeMap$Node right;
        if (root == null) {
            if (comparator == LinkedTreeMap.NATURAL_ORDER && !(o instanceof Comparable)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(" is not Comparable");
                throw new ClassCastException(sb.toString());
            }
            right = new LinkedTreeMap$Node(root, o, header, header.prev);
            this.root = right;
        }
        else {
            right = new LinkedTreeMap$Node(root, o, header, header.prev);
            if (n < 0) {
                root.left = right;
            }
            else {
                root.right = right;
            }
            this.rebalance(root, n3 != 0);
        }
        this.size += n3;
        this.modCount += n3;
        return right;
    }
    
    LinkedTreeMap$Node findByEntry(final Entry entry) {
        final LinkedTreeMap$Node byObject = this.findByObject(entry.getKey());
        LinkedTreeMap$Node linkedTreeMap$Node;
        if (byObject != null && this.equal(byObject.value, entry.getValue())) {
            linkedTreeMap$Node = byObject;
        }
        else {
            linkedTreeMap$Node = null;
        }
        return linkedTreeMap$Node;
    }
    
    LinkedTreeMap$Node findByObject(final Object o) {
        LinkedTreeMap$Node find = null;
        if (o != null) {
            try {
                find = this.find(o, false);
            }
            catch (ClassCastException ex) {
                return null;
            }
        }
        return find;
    }
    
    public Object get(final Object o) {
        final LinkedTreeMap$Node byObject = this.findByObject(o);
        Object value;
        if (byObject != null) {
            value = byObject.value;
        }
        else {
            value = null;
        }
        return value;
    }
    
    public Set keySet() {
        final LinkedTreeMap$KeySet keySet = this.keySet;
        LinkedTreeMap$KeySet keySet2;
        if (keySet != null) {
            keySet2 = keySet;
        }
        else {
            keySet2 = new LinkedTreeMap$KeySet(this);
            this.keySet = keySet2;
        }
        return keySet2;
    }
    
    public Object put(final Object o, final Object value) {
        if (o != null) {
            final LinkedTreeMap$Node find = this.find(o, true);
            final Object value2 = find.value;
            find.value = value;
            return value2;
        }
        throw new NullPointerException("key == null");
    }
    
    public Object remove(final Object o) {
        final LinkedTreeMap$Node removeInternalByKey = this.removeInternalByKey(o);
        Object value;
        if (removeInternalByKey != null) {
            value = removeInternalByKey.value;
        }
        else {
            value = null;
        }
        return value;
    }
    
    void removeInternal(final LinkedTreeMap$Node linkedTreeMap$Node, final boolean b) {
        if (b) {
            linkedTreeMap$Node.prev.next = linkedTreeMap$Node.next;
            linkedTreeMap$Node.next.prev = linkedTreeMap$Node.prev;
        }
        final LinkedTreeMap$Node left = linkedTreeMap$Node.left;
        final LinkedTreeMap$Node right = linkedTreeMap$Node.right;
        final LinkedTreeMap$Node parent = linkedTreeMap$Node.parent;
        if (left != null && right != null) {
            LinkedTreeMap$Node linkedTreeMap$Node2;
            if (left.height > right.height) {
                linkedTreeMap$Node2 = left.last();
            }
            else {
                linkedTreeMap$Node2 = right.first();
            }
            this.removeInternal(linkedTreeMap$Node2, false);
            int height = 0;
            final LinkedTreeMap$Node left2 = linkedTreeMap$Node.left;
            if (left2 != null) {
                height = left2.height;
                linkedTreeMap$Node2.left = left2;
                left2.parent = linkedTreeMap$Node2;
                linkedTreeMap$Node.left = null;
            }
            int height2 = 0;
            final LinkedTreeMap$Node right2 = linkedTreeMap$Node.right;
            if (right2 != null) {
                height2 = right2.height;
                linkedTreeMap$Node2.right = right2;
                right2.parent = linkedTreeMap$Node2;
                linkedTreeMap$Node.right = null;
            }
            linkedTreeMap$Node2.height = Math.max(height, height2) + 1;
            this.replaceInParent(linkedTreeMap$Node, linkedTreeMap$Node2);
            return;
        }
        if (left != null) {
            this.replaceInParent(linkedTreeMap$Node, left);
            linkedTreeMap$Node.left = null;
        }
        else if (right != null) {
            this.replaceInParent(linkedTreeMap$Node, right);
            linkedTreeMap$Node.right = null;
        }
        else {
            this.replaceInParent(linkedTreeMap$Node, null);
        }
        this.rebalance(parent, false);
        --this.size;
        ++this.modCount;
    }
    
    LinkedTreeMap$Node removeInternalByKey(final Object o) {
        final LinkedTreeMap$Node byObject = this.findByObject(o);
        if (byObject != null) {
            this.removeInternal(byObject, true);
        }
        return byObject;
    }
    
    public int size() {
        return this.size;
    }
}
