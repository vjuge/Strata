/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.key;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.currency.CurrencyPair;
import com.opengamma.strata.basics.index.FxIndex;
import com.opengamma.strata.basics.market.MarketDataKey;

/**
 * Market data key identifying an FX rate.
 * <p>
 * This is used when there is a need to obtain the current FX rate for a currency pair.
 * Historic FX rates are available using {@link FxIndex}.
 */
@BeanDefinition(builderScope = "private")
public final class FxRateKey
    implements MarketDataKey<Double>, ImmutableBean, Serializable {

  /**
   * The currency pair that is required.
   * For example, 'GBP/USD'.
   */
  @PropertyDefinition(validate = "notNull")
  private final CurrencyPair pair;

  //-------------------------------------------------------------------------
  /**
   * Creates a key to obtain the market FX rate associated with a currency pair.
   *
   * @param currencyPair  the currency pair
   * @return a key for the FX rate
   */
  public static FxRateKey of(CurrencyPair currencyPair) {
    return new FxRateKey(currencyPair);
  }

  /**
   * Creates a key to obtain the market FX rate associated with a currency pair.
   *
   * @param base  the base currency of the pair
   * @param counter  the counter currency of the pair
   * @return a key for the FX rate
   */
  public static FxRateKey of(Currency base, Currency counter) {
    return new FxRateKey(CurrencyPair.of(base, counter));
  }

  //-------------------------------------------------------------------------
  @Override
  public Class<Double> getMarketDataType() {
    return Double.class;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code FxRateKey}.
   * @return the meta-bean, not null
   */
  public static FxRateKey.Meta meta() {
    return FxRateKey.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(FxRateKey.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private FxRateKey(
      CurrencyPair pair) {
    JodaBeanUtils.notNull(pair, "pair");
    this.pair = pair;
  }

  @Override
  public FxRateKey.Meta metaBean() {
    return FxRateKey.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency pair that is required.
   * For example, 'GBP/USD'.
   * @return the value of the property, not null
   */
  public CurrencyPair getPair() {
    return pair;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      FxRateKey other = (FxRateKey) obj;
      return JodaBeanUtils.equal(getPair(), other.getPair());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getPair());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("FxRateKey{");
    buf.append("pair").append('=').append(JodaBeanUtils.toString(getPair()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code FxRateKey}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code pair} property.
     */
    private final MetaProperty<CurrencyPair> pair = DirectMetaProperty.ofImmutable(
        this, "pair", FxRateKey.class, CurrencyPair.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "pair");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3433178:  // pair
          return pair;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends FxRateKey> builder() {
      return new FxRateKey.Builder();
    }

    @Override
    public Class<? extends FxRateKey> beanType() {
      return FxRateKey.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code pair} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurrencyPair> pair() {
      return pair;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3433178:  // pair
          return ((FxRateKey) bean).getPair();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code FxRateKey}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<FxRateKey> {

    private CurrencyPair pair;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3433178:  // pair
          return pair;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3433178:  // pair
          this.pair = (CurrencyPair) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public FxRateKey build() {
      return new FxRateKey(
          pair);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("FxRateKey.Builder{");
      buf.append("pair").append('=').append(JodaBeanUtils.toString(pair));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
