/*
 * Copyright (c) Fisher and Paykel Appliances.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package hello;

public class Greeting {

	private final long id;
	private final String content;

	public Greeting(final long id, final String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return this.id;
	}

	public String getContent() {
		return this.content;
	}

}
